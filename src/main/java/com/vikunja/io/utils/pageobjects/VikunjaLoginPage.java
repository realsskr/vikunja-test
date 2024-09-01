package com.vikunja.io.utils.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VikunjaLoginPage
{

    @FindBy(xpath = "//a[contains(text(),'Create account')]")
    private WebElement createAccountLink;

    private final WebDriver driver;

    public VikunjaLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickCreateAccountLink()
    {
        createAccountLink.click();
        return new RegistrationPage(driver);
    }

}
