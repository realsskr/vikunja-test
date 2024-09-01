package com.vikunja.io.utils.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage
{

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "register-submit")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[@class='message danger']")
    private WebElement errorMessage;

    public final WebDriver driver;

    private final Logger logger = LogManager.getLogger();

    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage enterUsername(String username)
    {
        if (userName.isDisplayed() && userName.isEnabled())
        {
            userName.clear();
            userName.sendKeys(username);
            logger.info("Username entered: {}", username);
        }
        else
        {
            logger.error("Username text box is not displayed");
        }
        return this;
    }

    public RegistrationPage enterEmailAddress(String email)
    {
        if (emailAddress.isDisplayed() && emailAddress.isEnabled())
        {
            emailAddress.clear();
            emailAddress.sendKeys(email);
            logger.info("Email entered: {}", email);
        }
        else
        {
            logger.error("Email address text box is not displayed");
        }
        return this;
    }

    public void enterPassword(String pwd)
    {
        if (password.isDisplayed() && password.isEnabled())
        {
            password.clear();
            password.sendKeys(pwd);
            logger.info("Password entered: {}", pwd);
        }
        else
        {
            logger.error("Password text box is not displayed");
        }
    }

    public void clickCreateAccount()
    {
        if (createAccountButton.isDisplayed() && createAccountButton.isEnabled())
        {
            createAccountButton.click();
        }
        else
        {
            logger.error("Create account button is not displayed");
        }
    }

    public String verifyErrorMessage()
    {
        return errorMessage.getText();
    }

}
