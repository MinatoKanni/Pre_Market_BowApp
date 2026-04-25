package com.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.baseclass.BaseClass;

public class ScreenShort extends BaseClass {

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Starting: " + scenario.getName());
    }

    @After
    public void afterTest(Scenario scenario) {

        String status = scenario.getStatus().toString();

        takeScreenshot(scenario.getName() + "_" + status);

        if (scenario.isFailed()) {
            System.out.println("[FAILED] " + scenario.getName());
        } else {
            System.out.println("[PASSED] " + scenario.getName());
        }

        driver.manage().deleteAllCookies();
    }
}