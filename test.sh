#!/bin/sh
sed -i -e 's/ojdbcVersion=.*/ojdbcVersion=12.2.0.1/' gradle.properties
./gradlew run
sed -i -e 's/ojdbcVersion=.*/ojdbcVersion=18.3.0.0/' gradle.properties
./gradlew run
sed -i -e 's/ojdbcVersion=.*/ojdbcVersion=19.3.0.0/' gradle.properties
./gradlew run
sed -i -e 's/ojdbcVersion=.*/ojdbcVersion=19.6.0.0/' gradle.properties
./gradlew run
sed -i -e 's/ojdbcVersion=.*/ojdbcVersion=19.7.0.0/' gradle.properties
./gradlew run
