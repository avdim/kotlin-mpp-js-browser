Sampe of usage kotlin 1.3.40 mpp with js browser configuration
  
#### run development mode:  
`./gradlew jsBrowserRun`  
http://localhost:8080  
  
#### run production mode (with minified JS):  
`./gradlew runProduction`  
http://localhost:8081/index.html

#### production build:  
`./gradlew buildProduction`

#### run JS tests:
`./gradlew jsBrowserTest`  

#### Additional info      
I think that production build was difficult. I use 'kotlin-dce-js' plugin, webpack.config.d and copy js files with my hands. It seems this process should be easier. I would be happy to receive advice on how to simplify it.  
Look at:  
- settings.gradle.kts -> 'kotlin-dce-js' plugin workaround
- build.gradle.kts -> "buildProduction" task,  
- webpack.config.d/production.js  
  
  
I am using Linux Ubuntu. On MacOs and Windows did not check.  
Contributions are welcome!  
You can find me at https://kotlinlang.slack.com (avdim)  
  
#### Question to JetBrains Kotlin/JS team:
It seems the 'gradle js-dce' plugin does not integrate well with the new kotlin ("multiplatform") (or kotlin ("js")).  
It may be better to enable the DCE options in the MPP plugin, for example:  
in `build.gradle.kts`
```Kotlin
kotlin {
    js {
        browser {
            dce = true
            //...
        }
        nodejs {
            dce = false
            //...        
        }
    }
}
```
What is the future of kotlin-dce-js plugin and KotlinJS minifier tools?  
  
#### Thanks to opensource community:
For inspiration: https://github.com/ilgonmic/kotlinjs-multi-module  
https://github.com/ilgonmic  
https://github.com/snrostov  
https://github.com/h0tk3y  
and of course all Kotlin team  
