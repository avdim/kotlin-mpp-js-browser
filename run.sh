#!/usr/bin/env bash
#rm -rf build
./gradlew clean
./gradlew runProduction
du -sh build/production/*