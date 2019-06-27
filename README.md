Sampe of usage kotlin 1.3.40 mpp with js browser configuration
  
#### run development mode:  
`./gradlew jsBrowserRun`  
http://localhost:8080  
  
#### run production mode (with minified JS):  
`./gradlew runProduction`  
http://localhost:8081/index.html  

#### run JS tests:
`./gradlew jsBrowserTest`  

#### Additional info      
I think that production build was difficult. I use DCE, webpack.config.d and copy js files with my hands. It seems this process should be easier. I would be happy to receive advice on how to simplify it.  
  
I am using Linux Ubuntu. On MacOs and Windows did not check.  
Contributions are welcome!  
    
#### Thanks to opensource community:
For inspiration: https://github.com/ilgonmic/kotlinjs-multi-module  
https://github.com/h0tk3y  
https://github.com/ilgonmic  
https://github.com/snrostov  
  