[![N|Solid](https://bobit.us/wp-content/uploads/2021/04/bobit-logo.png)](https://bobit37.github.io/Resume/)

# MasterTestNGSeleniumFramework

This framework is developed by using Selenium 4.0 and JDK.11

All framework creation is specified in the branches step by step. If you start from section_1 branch and go through other branches, you can follow creation of the framework.

This project consists of UI and API tests. Selenium + JDK 11 are used for UI and and RestAssured library is used for API which starts branch of section_10.

## Required Technologies
- Selenium 4.0
- JDK.11
- TestNG 7.3.0
- Rest Assured 4.4.0
- JSoup 1.13.1

## Specify project path on the terminal
- cd project path

## to execute all test cases
- mvn -Dtest=class_name test

## to execute specific test case
- mvn -Dtest=class_namet#methodname test

## without command line
- go to test root directory and then execute testng.xml file
