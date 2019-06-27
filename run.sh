#!/usr/bin/env bash
./gradlew buildProduction
du -sh build/production/*
./gradlew runProduction