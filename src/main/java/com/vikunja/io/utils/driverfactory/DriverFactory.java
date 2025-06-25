package com.vikunja.io.utils.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.time.Duration;

@Slf4j
public class DriverFactory
{

    @Getter
    public static WebDriver driver = null;

    public WebDriver initializeDriver(String browserName)
    {
        log.info("Starting execution using {}", browserName);

        if (browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().fullscreen();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().fullscreen();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().fullscreen();
        }
        else if (browserName.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }
        else
        {
            log.error("Please pass correct browser value: {}", browserName);
        }
        return getDriver();
    }

}
