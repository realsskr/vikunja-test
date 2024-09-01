package com.vikunja.io.utils;

public class PropertiesHandler
{

    private PropertiesHandler() {}

    public static String getBrowser()
    {
        return System.getProperty(SystemKeys.BROWSER);
    }

    public static String getUrl()
    {
        return System.getProperty(SystemKeys.TESTING_URL);
    }

}
