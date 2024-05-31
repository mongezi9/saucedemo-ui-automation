package com.saucedemo.tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/saucedemo/tests/stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = "@LoginTest"

)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}