package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class Chart extends BaseClass {

    @When("User Select The {string} Stock or F&O to Chart")
    public void user_select_the_stock_or_f_o_to_chart(String stock) throws InterruptedException {

        WebElement stockElement = waitForClickable(
                By.xpath("//*[contains(text(),'" + stock + "')]"));

        jsClick(stockElement);

        switchToChartFrame();

        WebElement interval = waitForClickable(By.id("header-toolbar-intervals"));
        interval.click();

        waitForClickable(By.xpath("//div[@data-value='1']")).click();

        String v1 = getChartValue();
        Thread.sleep(3000);
        String v2 = getChartValue();

        if (v1.equals(v2)) {
            System.out.println("Chart stable: " + v1);
        } else {
            System.out.println("Chart fluctuating");
        }

        switchToDefault();
    }

    private String getChartValue() {

        WebElement value = waitForElement(
                By.xpath("//div[contains(@class,'pane-legend')]//div[last()]"));

        return value.getText();
    }
}