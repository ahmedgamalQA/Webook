## Table of contents
* [About The Project](#about-the-project)
* [Built With](#built-with)
* [Prerequisites](#prerequisites)
* [Installation and Run](#installation-and-run)
* [Design Patterns & Concepts](#design-patterns-and-concepts)
* [Project Structure](#project-structure)
* [StepDefinitions.Tests Scenarios](#test-scenarios)
## About The Project

This project is part of the Web & API StepDefinitions.Tests Automation Challenge. The objective is to automate a specific scenario on the Website:https://webook.com/en using Selenium and Cucumber And TestNG.
This challenge tests the functionality, design patterns, code structure, and overall cleanliness and documentation of the automation code.

## Built With

This section should list any major dependencies/libraries used to bootstrap this project.

* [![Java][Java]][Java-url]
* [![Selenium][Selenium]][Selenium-url]
* [![TestNG][TestNG]][TestNG-url]
* [![JsonSimple][JsonSimple]][JsonSimple-url]

## Prerequisites

Before running the automation script for the https://webook.com/en using Selenium, ensure the following prerequisites are met:
1. **Java 17 Development Kit (JDK):**
    - Ensure JDK 17 is installed on your system.
    - You can download it from the official [Java SE Downloads](https://www.oracle.com/java/technologies/downloads). page.
    -  Verify the installation by running the following command in your terminal:
       //bash "java -version"


2. **Development Environment - Aqua IDE:**
    - Download and install Aqua IDE (JetBrains' IDE designed for test automation and QA professionals).
    - You can get it from the official website: [Aqua IDE](https://www.jetbrains.com/aqua/).
    - Ensure Aqua is configured properly with the required plugins for Selenium and testing frameworks like Cucumber.


3. **Allure Report Setup:**
    - Download the latest Allure CLI release from the [Allure GitHub repository](https://github.com/allure-framework/allure2).
    - Extract the downloaded zip file.
    - Add the bin folder to your system's PATH environment variable.
    - Verify Installation: Run the following command to confirm Allure is installed: "allure --version".
    - Generate and Serve Allure Reports: "allure serve allure-results"



## Installation and Run
**GitHub:**
- Install Git on your system by downloading it from the [Git Website](https://git-scm.com/downloads).


1. Clone the repo
   ```sh
   git clone https://github.com/ahmedgamalQA/Webook.git
   ```

2. Run the scenarios By add tag in class found at `src/test/java/Runners/TestRunner.java`:


## Design Patterns and Concepts
* [Page-Object-Model Pattern **POM**](#pom)
* [Singleton Design Pattern](#singleton-design-pattern)
* [Method Chaining Concept](#method-chaining-concept)
* [Static Factory Method](#static-factory-method)
* [Data Driven Techniques](#data-driven-techniques)
## Project Structure
* **Consists of three part**
    - Main part which contains our PagesClasses
    - StepDefinitions.Tests part which contains our Listeners and Reports, TestsClasses
    - resources part which contains features and properties
## POM
* Page Object Model (POM) is a design pattern, popularly used in test automation that creates Object Repository for UI elements.
* The advantage of the model is that it reduces code duplication and improves test maintenance.
* We separate the framework (coding part) from the testing part.
* We represent each screen in our application by Class in the framework.
* You can read more about POM structure on:
    - [Guru99](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)
    - [GeeksForGeeks](https://www.geeksforgeeks.org/page-object-model-pom/)
    - [Official Selenium](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
    - [BrowserStack](https://www.browserstack.com/guide/page-object-model-in-selenium)
------------------------------------------
## StepDefinitions.Tests Scenarios

```gherkin
@WebTests
Feature: WeBook Website
  Sample test to use as basis for conversion


  Background:
    Given the user navigates to the homepage

  @TC1
  Scenario: Register a new user account
    When the user clicks the Sign Up button on the homepage
    And the user fills in all required fields
    Then the user should be logged in successfully
    And the user's username and email should be correct

  @TC2
  Scenario: TC2 :user search
    When user search by "Les Deux Magots" in search field
    Then Assert the title of the result is contains: "Les Deux Magots"
    And verify the search results contains "Les Deux Magots"

  @TC3
  Scenario: TC3: user filter
    When user search by "Al Shabab" in search field
    And Filter to display "Riyadh" location Only
    Then Assert the search results contains "Riyadh"
```


[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://docs.oracle.com/en/java/
[Selenium]: https://img.shields.io/badge/selenium-webdriver-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[Selenium-url]: https://www.selenium.dev/documentation/webdriver/
[Appium]: https://img.shields.io/badge/Appium-41BDF5?style=for-the-badge&logo=appium&logoColor=white
[Appium-url]: https://appium.io/docs/en/latest/
[TestNG]: https://img.shields.io/badge/TestNg-FF7F00?style=for-the-badge&logo=testng&logoColor=white
[TestNG-url]: https://testng.org/
[JsonSimple]: https://img.shields.io/badge/JSON_Simple-000000?style=for-the-badge&logo=json&logoColor=white
[Cucumber]: https://img.shields.io/badge/Cucumber-000000?style=for-the-badge&logo=json&logoColor=white
[Cucumber-url]: https://cucumber.io/docs/guides/overview/
[JsonSimple-url]: https://www.digitalocean.com/community/tutorials/json-simple-example