#!/usr/bin/env bash
./gradlew clean
./gradlew runDceJsKotlin
./gradlew jsBrowserWebpack

du -sh build/libs/some-app.js

rm -rf build/result
mkdir build/result
cp -r build/libs/* build/result/
cp -r src/jsMain/resources/* build/result/

#docker run -it --rm -v $PWD/build/result:/usr/share/nginx/html -p 8080:80 nginx:alpine
./gradlew runProd
