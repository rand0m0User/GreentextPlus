@echo off
gradlew_ForPeopleWithAFuckedJavaEnv build
rem gradlew build

cd "build\libs"
del *-dev.jar
"..\..\advzip.exe" -z -3 *.jar
rem