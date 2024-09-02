# vikunja-test

## Table of contents

- [Overview](#overview)
- [Pre-Requisites](#pre-requisites)
- [Setup](#setup)
- [Project Structure](#project-structure)
- [Features](#features)
  
---

### Overview
'''shell
This project is a test automation framework designed for web application testing using Cucumber, Selenium WebDriver, and Log4j2 for logging. The framework supports running tests with different browsers and provides detailed reports using ExtentReports.
'''

### Pre-Requisites

Before you begin, ensure you have the following installed on your machine:

Java JDK (version 11 or higher recommended)

Maven (for dependency management and build)


### Setup

Cone the repo

Install the Dependencies

Adjust the browser in system.properties file under package src/test/resources/

Run test using maven


### Project Structure

src/test/resources/features/ - Contains the feature files written in Gherkin.

src/test/java/com/vikunja/io/testrunner/ - Contains the TestRunner class for running the Cucumber tests.

src/test/java/com/vikunja/io/stepdefinitions/ - Contains step definitions that map Gherkin steps to Java methods.

src/test/java/com/vikunja/io/hooks/ - Contains hooks for setup and teardown operations.

src/main/java/com/vikunja/io/utils/ - Contains utility classes like DriverFactory for browser initialization and SystemPropertiesHandler for configuration and Pageobjects


### Features

Cucumber for behavior-driven development (BDD).

Selenium WebDriver for browser automation.

Log4j2 for advanced logging and reporting.

ExtentReports for detailed HTML test reports.

Dynamic screenshot capturing for failed scenarios.


#### Logs

Logs can be found in **target/logs** after running the tests


#### Screenshots

If the scenario is failed, screenshots will be saved to **target/FailedScreenshots/** folder

If the scenario is passed, screenshots will be saved to **target\test-output\screenshots** folder


#### Reports

After running the tests, different type of reports are generated

Cucumber html report is available in target folder with **testReport.html**

PDF report is available in **target\test-output\PdfReport** folder

Extent report is available in **target\test-output\ExtentReport** folder
