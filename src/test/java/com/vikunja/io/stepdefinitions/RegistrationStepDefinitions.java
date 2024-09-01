package com.vikunja.io.stepdefinitions;

import com.vikunja.io.utils.DriverUtilities;
import com.vikunja.io.utils.PropertiesHandler;
import com.vikunja.io.utils.driverfactory.DriverFactory;
import com.vikunja.io.utils.pageobjects.VikunjaLoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistrationStepDefinitions
{

    Logger logger = LogManager.getLogger();

    private final VikunjaLoginPage vikunjaLoginPage = new VikunjaLoginPage(DriverFactory.getDriver());
    DriverUtilities driverUtilities = new DriverUtilities();

    @Given("user is on vikunja page")
    public void userIsOnVikunjaPage()
    {
        DriverFactory.getDriver().get(PropertiesHandler.getUrl());

        logger.info("User is on vikunja page");
        log.info("User is on vikunja page");
    }

    @And("user clicks on create account link")
    public void userClicksOnCreateAccountLink()
    {
        vikunjaLoginPage.clickCreateAccount();
    }

    @Then("user should be navigated to registration page")
    public void userShouldBeNavigatedToRegistrationPage()
    {
    }

    @When("user enters {string} {string} and {string}")
    public void userEntersAnd(String arg0, String arg1, String arg2)
    {
    }

    @And("user clicks on create account button")
    public void userClicksOnCreateAccountButton() throws InterruptedException
    {

    }

    @Then("user should be navigated to homepage")
    public void userShouldBeNavigatedToHomepage()
    {
    }
}
