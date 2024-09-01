package com.vikunja.io.hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vikunja.io.utils.DriverUtilities;
import com.vikunja.io.utils.driverfactory.DriverFactory;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks
{

    DriverFactory driverFactory;
    private final DriverUtilities driverUtilities = new DriverUtilities();
    private WebDriver driver;

    Logger logger = LogManager.getLogger();

    @Before(order = 0)
    public void setLogger(Scenario scenario)
    {

        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
        String logFileName = String.format("logfile-%s_%s", scenarioName, timestamp);

        System.setProperty("logFileName", logFileName);

        ThreadContext.put("logFileName", logFileName);
        logger.info("Starting scenario: {}", scenarioName);
    }

    @Before(order = 1)
    public void openBrowser()
    {
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver();
    }

    @After(order = 2)
    public void screenshot(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            String ScreenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try
            {
                FileUtils.copyFile(screenshotFile,
                                   new File("target/FailedScreenshots/" + ScreenshotName + " " + new SimpleDateFormat(
                                           "yyyyMMdd-HHmmss").format(new Date()) + ".png"));
            }
            catch (IOException e)
            {
                Logger logger = LogManager.getLogger();
                logger.info(e.getLocalizedMessage());
            }
        }
    }

    @After(order = 1)
    public void tearDownLogging(Scenario scenario)
    {
        //        Logger logger = LogManager.getLogger();
        if (scenario.isFailed())
        {
            logger.error("Scenario failed: {}", scenario.getName());
        }
        else
        {
            logger.info("Scenario passed: {}", scenario.getName());
        }
        ThreadContext.clearAll();

    }

    @After(order = 0)
    public void closeBrowser()
    {
        driver.quit();
        logger.info("Quit the browser");
    }

    @AfterStep
    public void as(Scenario scenario) throws IOException
    {
        scenario.attach(driverUtilities.getByteScreenshot(), "image/png", "screenshot name");
    }

}
