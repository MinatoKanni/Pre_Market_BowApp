package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class CommonSteps extends BaseClass {

    @When("Navigate to home page")
    public void navigate_to_home_page() {
        driver.get("https://rocket.tradeplusonline.com/");
        waitForPageLoad();

        waitForElement(By.xpath("//input[@id='project-id']"));
    }

    @When("User click the search box")
    public void user_click_the_search_box() {

        WebElement search = waitForClickable(
                By.xpath("//input[@id='project-id']"));

        search.click();
    }

    @When("User Search any {string} Script")
    public void user_search_any_script(String script) {

        WebElement search = waitForElement(
                By.xpath("//input[@id='project-id']"));

        search.clear();
        search.sendKeys(script);
    }

    @When("User Click The Withdraw button")
    public void user_click_the_withdraw_button() {

        WebElement withdraw = waitForClickable(
                By.xpath("//button[text()='Withdraw']"));

        withdraw.click();
    }

    @When("User Click Add Money")
    public void user_click_add_money() {

        WebElement addMoney = waitForClickable(
                By.xpath("//button[@data-dhx-id='btn_addmoney']"));

        addMoney.click();
    }
}