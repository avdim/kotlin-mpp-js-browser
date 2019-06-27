import org.jetbrains.kotlin.gradle.tasks.*

plugins {
    kotlin("multiplatform") version "1.3.40"
    id("kotlin-dce-js") version "1.3.40"
}

repositories {
    jcenter()
}

kotlin {
    js {
        browser {
            configure(listOf(compilations["main"], compilations["test"])) {
                (tasks.getByName(compileKotlinTaskName) as Kotlin2JsCompile).kotlinOptions {
                    moduleKind = "umd"
                    metaInfo = false
                    sourceMap = false
                }
            }
            webpackTask {
                sourceMaps = false
                report = true // execute src/jsTest
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    usePhantomJS()
                }
            }
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependsOn(jsMain)
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

tasks {
    register("runProd") {
        doLast {
            SimpleHttpFileServerFactory().start(
                    file("build/result"),
                    8081
            )
            println("Open http://localhost:8081/index.html")
            Thread.sleep(Long.MAX_VALUE)
        }
    }
}
