package com.vikunja.io.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemPropertiesHandler
{

    private final Logger logger = LogManager.getLogger();

    public Properties initializeproperties()
    {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/system.properties"))
        {
            properties.load(fis);
        }
        catch (IOException e)
        {
            logger.error("File not found: {}", e.getMessage());
        }
        return properties;
    }

}
