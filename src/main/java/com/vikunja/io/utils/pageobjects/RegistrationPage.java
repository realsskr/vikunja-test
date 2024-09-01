package com.vikunja.io.utils.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    public final WebDriver driver;

    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username)
    {
        if (userName.isDisplayed() && userName.isEnabled())
        {
            userName.clear();
            userName.sendKeys(username);
        }
        else
        {
            log.error("Username text box is not displayed");
        }
    }

    public void enterEmailAddress(String email)
    {
        if (emailAddress.isDisplayed() && emailAddress.isEnabled())
        {
            emailAddress.clear();
            emailAddress.sendKeys(email);
        }
        else
        {
            log.error("Email address text box is not displayed");
        }
    }

    public void enterPassword(String pwd)
    {
        if (password.isDisplayed() && password.isEnabled())
        {
            password.clear();
            password.sendKeys(pwd);
        }
        else
        {
            log.error("Password text box is not displayed");
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
            log.error("Create account button is not displayed");
        }
    }

}
