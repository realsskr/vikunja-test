package com.vikunja.io.stepdefinitions;

import com.vikunja.io.utils.driverfactory.DriverFactory;
import com.vikunja.io.utils.pageobjects.RegistrationPage;
import com.vikunja.io.utils.pageobjects.VikunjaLoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps
{

    private final WebDriver driver = DriverFactory.getDriver();
    private final Logger logger = LogManager.getLogger();
    private final VikunjaLoginPage vikunjaLoginPage = new VikunjaLoginPage(driver);
    private RegistrationPage registrationPage;

    @Given("user is on vikunja page")
    public void userIsOnVikunjaPage()
    {
        DriverFactory.getDriver().get("https://try.vikunja.io");
        logger.info("User is on vikunja page");
    }

    @And("user clicks on create account link")
    public void userClicksOnCreateAccountLink()
    {
        registrationPage = vikunjaLoginPage.clickCreateAccountLink();
    }

    @Then("user should be navigated to registration page")
    public void userShouldBeNavigatedToRegistrationPage()
    {
        Assert.assertEquals("https://try.vikunja.io/register", DriverFactory.getDriver().getCurrentUrl());
    }

    @When("user enters {string} {string} and {string}")
    public void userEntersAnd(String userName, String email, String password)
    {
        registrationPage.enterUsername(userName).enterEmailAddress(email).enterPassword(password);
    }

    @And("user clicks on create account button")
    public void userClicksOnCreateAccountButton()
    {
        registrationPage.clickCreateAccount();
    }

    @Then("user should be presented with {string} error message")
    public void userShouldBePresentedWithErrorMessage(String errorMessage)
    {
        logger.info("Error message displayed for the user " + registrationPage.verifyErrorMessage());
        Assert.assertEquals(errorMessage, registrationPage.verifyErrorMessage());
    }
}
