package com.vikunja.io.utils;

import java.io.File;
import java.io.IOException;

import com.vikunja.io.utils.driverfactory.DriverFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DriverUtilities
{

    public byte[] getByteScreenshot() throws IOException
    {
        File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        return FileUtils.readFileToByteArray(src);
    }

}
