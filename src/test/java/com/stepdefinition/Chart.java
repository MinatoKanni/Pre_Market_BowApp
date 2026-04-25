package com.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class Chart extends BaseClass {
	
	@When("User Choose {string} the Market WatchList")
	public void user_choose_the_market_watch_list(String string) throws InterruptedException {
	    
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement downArrow = driver.findElement(By.xpath("//button[@data-toggle='open_mm']"));

		Actions a = new Actions(driver);
		a.moveToElement(downArrow).perform();

		WebElement option = driver.findElement(By.xpath("(//span[text()='" + string + "']//parent::a)[2]"));
		a.moveToElement(option).perform();

		driver.findElement(By.xpath("(//span[text()='" + string + "']//parent::a)[2]")).click();

		WebElement any = driver.findElement(By.xpath("(//div[@mode='right'])[3]"));
		a.moveToElement(any).perform();

		Thread.sleep(2000);
		
		
		
	}

	@When("User Select The {string} Stock or F&O to Chart")
	public void user_select_the_stock_or_f_o_to_chart(String string) throws InterruptedException {
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='"+string+"']"));
		
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			//System.out.println(text);
			
			if (text.equals(string)) {
				
				Actions a = new Actions(driver);
				a.moveToElement(webElement).perform();
				
				List<WebElement> elements2 = driver.findElements(By.xpath("(//span[text()='"+string+"']//ancestor::div[@class='m_bg_color']//descendant::span[@class='s_b2 chart'])[1]"));
				
				for (WebElement webElement2 : elements2) {
					
					if(webElement2.isDisplayed()) {
						
						a.moveToElement(webElement2).perform();
						Thread.sleep(2000);
						a.click(webElement2).perform();
						
					}
					
					
				}
				
				
//				WebElement option = driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_b2 chart'])[1]"));
//				a.moveToElement(option).perform();
//
//				driver.findElement(By.xpath("(//span[text()='"+string+"']//parent::div//following-sibling::div//child::span[@class='s_b2 chart'])[1]")).click();

				
				
			}		
			
		}
		
		Thread.sleep(2000);
		framesHandling();
		

		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();
		
		Thread.sleep(2000);
		
		WebElement element3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text2 = element3.getText();
		
		
		System.out.println("Feed Connection Value of One Minute : " + text2);
		
		Thread.sleep(4000);
		
		WebElement element2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text1 = element2.getText();
		System.out.println("Feed Connection Value of One Minute : " + text1);
		
		if (text2.equals(text1)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text1);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();
		
		Thread.sleep(2000);
		
		WebElement element31 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text212 = element31.getText();
		System.out.println("Feed Connection Value of One Minute : " + text212);
		
		Thread.sleep(4000);
		
		WebElement element21 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text112 = element21.getText();
		System.out.println("Feed Connection Value of One Minute : " + text112);
		
		if (text212.equals(text112)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text112);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		outOfFrames();
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		
		Thread.sleep(2000);
	}
	
	@When("User Check the one Minute and one Day Chart")
	public void user_check_the_one_minute_and_one_day_chart() throws InterruptedException {
	   
		Thread.sleep(2000);
	//	framesHandling();
		

		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();
		
		Thread.sleep(2000);
		
		WebElement element3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text2 = element3.getText();
		
		
		System.out.println("Feed Connection Value of One Minute : " + text2);
		
		Thread.sleep(4000);
		
		WebElement element2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text1 = element2.getText();
		System.out.println("Feed Connection Value of One Minute : " + text1);
		
		if (text2.equals(text1)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text1);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();
		
		Thread.sleep(2000);
		
		WebElement element31 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text211 = element31.getText();
		System.out.println("Feed Connection Value of One Minute : " + text211);
		
		Thread.sleep(4000);
		
		WebElement element21 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		
		String text111 = element21.getText();
		System.out.println("Feed Connection Value of One Minute : " + text111);
		
		if (text211.equals(text111)) {
			
			String blue = "\u001B[34m";
			System.err.println(blue+"One Minute Chart Value to Pass : " + text111);
		}
		
		else {
			
			System.err.println("Feed Connection Faild");
		}
		
		outOfFrames();
		
		driver.findElement(By.xpath("//button[@data-dhx-id='close']")).click();

		
		Thread.sleep(2000);
		
	}

	@When("User Naviagate to Market WatchList")
	public void user_naviagate_to_market_watch_list() {
	    
		
		
		
	}

}
