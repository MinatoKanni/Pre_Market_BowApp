package com.stepdefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.baseclass.BaseClass;
import com.pom.Login_Navia_POM;

import io.cucumber.java.Before;

public class Login extends BaseClass {

    Login_Navia_POM l;
    WebDriverWait wait;

    @Before
    public void setup() throws Exception {

        launchBrowser("Chrome");

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        l = new Login_Navia_POM(driver);

        driver.get("https://yopmail.com/en/?naviatesting@yopmail.com");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get("https://rocket.tradeplusonline.com/login.php");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[@id='login_fsmt1'])[2]"))).click();

        l.getClientCode().sendKeys("63748379");
        l.getPassWord().sendKeys("Navia@1234");

        l.getCheckBox().click();
        l.getLogin().click();

        driver.switchTo().window(tabs.get(0));

        Thread.sleep(8000);

        driver.findElement(By.id("refresh")).click();
        Thread.sleep(5000);

        driver.switchTo().frame("ifmail");

        String otp = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong")))
                .getText();

        driver.switchTo().defaultContent();
        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.id("userotp")).sendKeys(otp);
        l.getLoginAfterOTP().click();

        wait.until(ExpectedConditions.urlContains("rocket.tradeplusonline"));
    }
}