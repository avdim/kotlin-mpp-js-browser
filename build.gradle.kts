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
                }
            }
            webpackTask {
                sourceMaps = false
                report = true //Enable execute tests src/jsTest
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

val PRODUCTION_DIR = "build/production"
tasks {
    named("jsBrowserWebpack") {
        dependsOn("runDceJsKotlin")
    }

    named("jsBrowserTest") {
        dependsOn("runDceJsKotlin")
    }

    register("buildProduction", Copy::class.java) {
        setDescription("generate directory $PRODUCTION_DIR")
        dependsOn("jsBrowserWebpack")
        dependsOn("jsBrowserTest")
        from("build/libs") {
            include("*.js")
        }
        from("src/jsMain/resources")
        into(PRODUCTION_DIR)
    }

    register("runProduction") {
        setDescription("run simple web server with content: $PRODUCTION_DIR")
        dependsOn("buildProduction")
        doLast {
            val port = 8081
            SimpleHttpFileServerFactory().start(
                    file(PRODUCTION_DIR),
                    port
            )
            println("Open http://localhost:$port/index.html")
            Thread.sleep(Long.MAX_VALUE)
        }
    }

    named("build") {
        dependsOn("buildProduction")
    }
}
