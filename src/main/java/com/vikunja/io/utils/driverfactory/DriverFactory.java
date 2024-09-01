package com.vikunja.io.utils.driverfactory;

import com.vikunja.io.utils.SystemPropertiesHandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriverFactory
{

    private static final String BROWSER_NAME = SystemPropertiesHandler.getBrowser();

    @Getter
    public static WebDriver driver;

    public WebDriver initializeDriver()
    {
        log.info("Starting execution using " + BROWSER_NAME);

        if (BROWSER_NAME.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (BROWSER_NAME.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (BROWSER_NAME.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else
        {
            log.error("Please pass correct browser value: " + BROWSER_NAME);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

}
