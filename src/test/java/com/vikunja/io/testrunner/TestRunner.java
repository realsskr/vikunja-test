package com.vikunja.io.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "com.vikunja.io.stepdefinitions", "com.vikunja.io.hooks" },
        plugin = { "pretty",
                "html:target/testReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@all"
)
public class TestRunner
{
}
