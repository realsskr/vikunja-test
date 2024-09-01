package com.vikunja.io.utils.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VikunjaLoginPage
{

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@type='secondary']")
    private WebElement createAccountLink;

    public final WebDriver driver;

    public VikunjaLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccount()
    {
        if (createAccountLink.isDisplayed() && createAccountLink.isEnabled())
        {
            createAccountLink.click();
        }
    }

}
