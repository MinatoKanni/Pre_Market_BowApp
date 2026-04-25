package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.baseclass.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/feature/DailyEightFortyTesting.feature",
    glue = {"com.stepdefinition"},
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"
    }
)
public class Runner {

    @BeforeClass
    public static void setup() {
        BaseClass.launchBrowser("Chrome");
    }

    @AfterClass
    public static void teardown() {
        BaseClass.quitBrowser();
    }
}