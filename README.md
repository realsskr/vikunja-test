# vikunja-test

**Overview**
This project is a test automation framework designed for web application testing using Cucumber, Selenium WebDriver, and Log4j2 for logging. The framework supports running tests with different browsers and provides detailed reports using ExtentReports.

**Features**
Cucumber for behavior-driven development (BDD).
Selenium WebDriver for browser automation.
Log4j2 for advanced logging and reporting.
ExtentReports for detailed HTML test reports.
Dynamic screenshot capturing for failed scenarios.

**Prerequisites**
Before you begin, ensure you have the following installed on your machine:
Java JDK (version 11 or higher recommended)
Maven (for dependency management and build)

**Project Structure**
src/test/resources/features/ - Contains the feature files written in Gherkin.
src/test/java/com/vikunja/io/testrunner/ - Contains the TestRunner class for running the Cucumber tests.
src/test/java/com/vikunja/io/stepdefinitions/ - Contains step definitions that map Gherkin steps to Java methods.
src/test/java/com/vikunja/io/hooks/ - Contains hooks for setup and teardown operations.
src/main/java/com/vikunja/io/utils/ - Contains utility classes like DriverFactory for browser initialization and SystemPropertiesHandler for configuration and Pageobjects

