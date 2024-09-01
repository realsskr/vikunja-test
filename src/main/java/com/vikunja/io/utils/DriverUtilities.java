package com.vikunja.io.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

import com.vikunja.io.utils.driverfactory.DriverFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtilities
{

    public byte[] getByteScreenshot() throws IOException
    {
        File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        return FileUtils.readFileToByteArray(src);
    }

    public void waitForPageToLoad(int timeoutInSeconds)
    {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> Objects.equals(js.executeScript("return document.readyState"), "complete"));
    }

    public void implicitWait(long timeoutInSeconds)
    {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    }

}
