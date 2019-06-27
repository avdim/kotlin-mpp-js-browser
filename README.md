Sampe of usage kotlin 1.3.40 mpp with js browser configuration
  
#### run development mode:  
`./gradlew jsBrowserRun`  
http://localhost:8080  
  
#### run production mode (with minified JS output):  
`./gradlew runProduction`
http://localhost:8081/index.html  

#### run JS tests:
`./gradlew jsBrowserTest`  
tests executes if in build.gradle `webpackTask { report = true }`

####Additional info    
Thanks for inspiration: https://github.com/ilgonmic/kotlinjs-multi-module  
  
I am using Linux Ubuntu. On MacOs and Windows did not check  
Contributions are welcome!  
  