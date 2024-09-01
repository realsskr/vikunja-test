package com.vikunja.io.hooks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class LoggingHooks
{

//    public static Logger log = LogManager.getLogger();
//
//    @Before(order=0)
//    public void setUpLogging(Scenario scenario) {
//        // Ensure the logs directory exists
//        File logsDir = new File("logs");
//        if (!logsDir.exists()) {
//            logsDir.mkdirs();
//        }
//
//        // Generate a unique log file name based on the scenario name and timestamp
//        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
//        String logFileName = String.format("logfile-%s_%s.log", scenarioName, timestamp);
//
//        // Set the log file name in the system property
//        System.setProperty("logFileName", logFileName);
//
//        // Update Log4j2 configuration
//        ThreadContext.put("logFileName", logFileName);
//        log.info("Starting scenario: {}", scenarioName);
//    }
//
//    @After(order=0)
//    public void tearDownLogging(Scenario scenario) {
//        if (scenario.isFailed()) {
//            log.error("Scenario failed: {}", scenario.getName());
//        } else {
//            log.info("Scenario passed: {}", scenario.getName());
//        }
//        ThreadContext.clearAll();
//    }

}
