package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;

    public static WebDriver launchBrowser(String browser) {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            boolean isCI = System.getenv("JENKINS_HOME") != null;

            if (isCI) {
                System.out.println("Running in Jenkins HEADLESS mode");
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // 🔥 WAITS
    public WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete"));
    }

    // 🔥 FRAME FIX
    public void switchToChartFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement frame1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'iframe_window')]")));

        driver.switchTo().frame(frame1);

        WebElement frame2 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[@title='Financial Chart']")));

        driver.switchTo().frame(frame2);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    // 🔥 SCREENSHOT
    public static void takeScreenshot(String name) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File dest = new File("target/screenshots/" + name + "_" + timestamp + ".png");

            Files.createDirectories(dest.getParentFile().toPath());
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}