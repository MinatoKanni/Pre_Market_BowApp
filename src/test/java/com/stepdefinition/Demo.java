package com.stepdefinition;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class Demo extends BaseClass{
	
	@When("User MouseOver Dashboard and Click Mutual Funds")
	public void user_mouse_over_dashboard_and_click_mutual_funds() throws InterruptedException {

		WebElement dashBoard = driver.findElement(By.xpath("(//span[text()='Dashboard']//ancestor::li)[1]"));

		Actions ac=new Actions(driver);
		ac.moveToElement(dashBoard).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Mutual Fund']//ancestor::li")).click();
		Thread.sleep(3000);
	}
	
	
	@When("User Click Explore")
	public void user_click_explore() throws InterruptedException {

		Thread.sleep(1000);

		driver.switchTo().frame(0);

		WebElement element = driver.findElement(By.xpath("//span[text()='Explore']//parent::button"));
		Actions ac = new Actions(driver);

		ac.moveToElement(element).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Explore']//parent::button")).click();
		Thread.sleep(1000);

	}
	
	
	@When("User Search {string} in Serach Box and enter")
	public void user_search_in_serach_box_and_enter(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(string);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + string + "']//parent::div")).click();
		Thread.sleep(1000);

	}
	
	@When("User Click enter UPI ID {string} and Click Pay Via UPI")
	public void user_click_enter_upi_id_and_click_pay_via_upi(String string) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter UPI ID']")).sendKeys(string);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Pay Via UPI']//parent::button")).click();

		Thread.sleep(13000);
		Actions ac = new Actions(driver);
		WebElement cancel = driver.findElement(By.xpath("//span[text()='Cancel Payment']//parent::button"));
		ac.moveToElement(cancel).perform();

		ac.click(cancel).perform();
		
		WebElement element = driver.findElement(By.xpath("//div[@class='go_home']//child::img"));
		element.click();

		Thread.sleep(2000);

	}
	
	@When("User Click The Current {string} Options")
	public void user_click_the_current_options(String string) throws InterruptedException {
	   
		Thread.sleep(5000);
		
		switch (string) {
		
		case "Nifty 50":
			
			WebElement element = driver
			.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
	element.click();
	
	Thread.sleep(1000);
	
	//Actions a = new Actions(driver);
	
	WebElement stock = driver
			.findElement(By.xpath("//span[text()='Nifty 50']"));
	
	stock.click();
	
//	a.moveToElement(stock).perform();
//	Thread.sleep(1000);
//	a.click(stock).perform();
	
	Thread.sleep(1000);
	
	WebElement fund = driver.findElement(By.xpath("(//span[text()='Nifty 50']//following-sibling::div//child::span)[1]"));
	String text = fund.getText();

	Thread.sleep(1000);
	
	double doubleValue = Double.parseDouble(text);

	// Convert to integer for rounding
	int intValue = (int) doubleValue;

	// Round to nearest 50, adjusting based on the fractional part
	int roundedValue;
	if (doubleValue % 50 > 0) {
	    roundedValue = ((intValue / 50) + 1) * 50; // Round up
	} else {
	    roundedValue = (intValue / 50) * 50; // Round down or stay as is
	}
	
	String purple = "\u001B[35m";

	System.out.println(purple+"Nifty Current Strike Value: " + roundedValue);
	
	Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id='project-id']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Nifty");
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[text()='Futures']")).click();
	Thread.sleep(2000);
	
	Actions a1 = new Actions(driver);
	WebElement stock1 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='NSE'])[1]"));
	Thread.sleep(1000);
	a1.moveToElement(stock1).perform();
	Thread.sleep(1000);
	a1.click(stock1).perform();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//lable[text()='F&O']//parent::button")).click();
	Thread.sleep(3000);
	
	WebElement element2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
	driver.switchTo().frame(element2);
	
	Thread.sleep(3000);
	WebElement element4 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
	String text2 = element4.getText();
	
	
	Thread.sleep(1000);
	if (text2.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
		
	} else {
		
		System.err.println("Ready-made strategy builder Close Button Not Working");

	}
	
	
	
//	Thread.sleep(1000);
//	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ready_mode_close']")));
//	element1.click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[text()='"+roundedValue+"']//parent::div//descendant::span)[1]")).click();
	Thread.sleep(2000);
	
	driver.switchTo().defaultContent();
	
	driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//span[text()='Clear']")).click();
	Thread.sleep(1000);
	
	Actions a = new Actions(driver);
	
		WebElement stocks = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue+"')]//preceding-sibling::span[text()='NSE']"));
		
		a.moveToElement(stocks).perform();
		Thread.sleep(1000);
		a.click(stocks).perform();
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='buy buyorder']"))
				.click();
			
			break;
			
      case "Sensex":
    	  Thread.sleep(1000);
    	  
    	  WebElement nifty = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX'])[1]"));
    	  String text3 = nifty.getText();
    	  System.out.println(text3);
    	  
    	  Thread.sleep(1000);
    	  if (text3.equalsIgnoreCase("S&P BSE SENSEX")) {
    		  
    		  Thread.sleep(1000);
    		  
    		  WebElement fund1 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX']//following-sibling::div//child::span)[1]"));
      		String text1 = fund1.getText();

      		Thread.sleep(1000);
      		
      		double doubleValue1 = Double.parseDouble(text1);

      		// Convert to integer for rounding
      		int intValue1 = (int) doubleValue1;

      		// Round to nearest 50, adjusting based on the fractional part
      		int roundedValue1;
      		if (doubleValue1 % 100 > 0) {
      		    roundedValue1 = ((intValue1 / 100) + 1) * 100; // Round up
      		} else {
      		    roundedValue1 = (intValue1 / 100) * 100; // Round down or stay as is
      		}
      		
      		
      		String purple1 = "\u001B[35m";
      		

      		System.out.println(purple1+"Sensex Current Strike Value: " + roundedValue1);
      		
      		Thread.sleep(2000);

      		driver.findElement(By.xpath("//input[@id='project-id']")).click();
      		Thread.sleep(1000);
      		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Sensex");
      		Thread.sleep(3000);

      		WebElement element5 = driver.findElement(By.xpath("//span[text()='Futures']"));
      		element5.click();
      		Thread.sleep(2000);
      		
      		Actions a2 = new Actions(driver);
      		WebElement stock2 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
      		Thread.sleep(1000);
      		a2.moveToElement(stock2).perform();
      		Thread.sleep(1000);
      		a2.click(stock2).perform();
      		
      		Thread.sleep(2000);
      		driver.findElement(By.xpath("//lable[text()='F&O']//parent::button")).click();
      		Thread.sleep(3000);
      		
      		WebElement element3 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
      		driver.switchTo().frame(element3);
      		
      		Thread.sleep(3000);
      		WebElement element41 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
      		String text12 = element41.getText();
      		
      		
      		
      		Thread.sleep(1000);
      		if (text12.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
      			
      			Thread.sleep(1000);
      			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
      			
      		} else {
      			
      			System.err.println("Ready-made strategy builder Close Button Not Working");

      		}
      		
      		Thread.sleep(1000);
      		Actions s = new Actions(driver);
      		
      		WebElement d = driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"'])[1]"));
      		
      		Thread.sleep(1000);
      		s.moveToElement(d).perform();
      		Thread.sleep(1000);
      		
      		driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//child::span)[1]")).click();
      		
      		Thread.sleep(2000);
      		
      		driver.switchTo().defaultContent();
      		
      		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
      		Thread.sleep(1000);
      		
      		driver.findElement(By.xpath("//span[text()='Clear']")).click();
      		Thread.sleep(1000);
      		
      		Actions a3 = new Actions(driver);
      		
      			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BSE']"));
      			
      			a3.moveToElement(stoc).perform();
      			Thread.sleep(1000);
      			a3.click(stoc).perform();
      		
      			Thread.sleep(2000);
      			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
      					.click();
    		  
			
		} else {


			WebElement element8 = driver
					.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
			element8.click();
			
			Thread.sleep(1000);
			
			//Actions a = new Actions(driver);
			
			WebElement stock111 = driver
					.findElement(By.xpath("//span[text()='S&P BSE SENSEX']"));
			
			stock111.click();
			
//			a.moveToElement(stock).perform();
//			Thread.sleep(1000);
//			a.click(stock).perform();
			
			Thread.sleep(1000);
    		
    		WebElement fund1 = driver.findElement(By.xpath("(//span[text()='S&P BSE SENSEX']//following-sibling::div//child::span)[1]"));
    		String text1 = fund1.getText();

    		Thread.sleep(1000);
    		
    		double doubleValue1 = Double.parseDouble(text1);

    		// Convert to integer for rounding
    		int intValue1 = (int) doubleValue1;

    		// Round to nearest 50, adjusting based on the fractional part
    		int roundedValue1;
    		if (doubleValue1 % 100 > 0) {
    		    roundedValue1 = ((intValue1 / 100) + 1) * 100; // Round up
    		} else {
    		    roundedValue1 = (intValue1 / 100) * 100; // Round down or stay as is
    		}
    		
    		
    		String purple1 = "\u001B[35m";
    		

    		System.out.println(purple1+"Sensex Current Strike Value: " + roundedValue1);
    		
    		Thread.sleep(2000);

    		driver.findElement(By.xpath("//input[@id='project-id']")).click();
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys("Sensex");
    		Thread.sleep(3000);

    		WebElement element5 = driver.findElement(By.xpath("//span[text()='Futures']"));
    		element5.click();
    		Thread.sleep(2000);
    		
    		Actions a2 = new Actions(driver);
    		WebElement stock2 = driver.findElement(By.xpath("(//div[@class='s-box']//child::span[text()='BSE'])[1]"));
    		Thread.sleep(1000);
    		a2.moveToElement(stock2).perform();
    		Thread.sleep(1000);
    		a2.click(stock2).perform();
    		
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//lable[text()='F&O']//parent::button")).click();
    		Thread.sleep(3000);
    		
    		WebElement element3 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
    		driver.switchTo().frame(element3);
    		
    		Thread.sleep(3000);
    		WebElement element41 = driver.findElement(By.xpath("//p[text()='Please click on a ready-made strategy to load it']"));
    		String text12 = element41.getText();
    		
    		
    		
    		Thread.sleep(1000);
    		if (text12.equalsIgnoreCase("Please click on a ready-made strategy to load it")) {
    			
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
    			
    		} else {
    			
    			System.err.println("Ready-made strategy builder Close Button Not Working");

    		}
    		
    		Thread.sleep(1000);
    		Actions s = new Actions(driver);
    		
    		WebElement d = driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"'])[1]"));
    		
    		Thread.sleep(1000);
    		s.moveToElement(d).perform();
    		Thread.sleep(1000);
    		
    		driver.findElement(By.xpath("(//div[text()='"+roundedValue1+"']//parent::div//child::span)[1]")).click();
    		
    		Thread.sleep(2000);
    		
    		driver.switchTo().defaultContent();
    		
    		driver.findElement(By.xpath("(//span[text()='Dashboard']//parent::a)[2]")).click();
    		Thread.sleep(1000);
    		
    		driver.findElement(By.xpath("//span[text()='Clear']")).click();
    		Thread.sleep(1000);
    		
    		Actions a3 = new Actions(driver);
    		
    			WebElement stoc = driver.findElement(By.xpath("//span[contains(text(),'"+roundedValue1+"')]//preceding-sibling::span[text()='BSE']"));
    			
    			a3.moveToElement(stoc).perform();
    			Thread.sleep(1000);
    			a3.click(stoc).perform();
    		
    			Thread.sleep(2000);
    			driver.findElement(By.xpath("//button[@class='buy buyorder']"))
    					.click();
		}
			break;

		default:
			break;
		}

		
		
//		WebElement fund1 = driver.findElement(By.xpath("(//span[text()='"+string+"']//following-sibling::div//child::span)[1]"));
//		String text31 = fund1.getText();
//
//		Thread.sleep(1000);
//		System.out.println(text31);
		
		Thread.sleep(2000);
		
		
	}
	

	@When("User Click One Time , enter amount {string} and click pay now")
	public void user_click_one_time_enter_amount_and_click_pay_now(String string) throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='One-Time']")).click();
		Thread.sleep(1000);
		WebElement amt = driver.findElement(By.xpath("//input[@data-dhx-id='ot_amt']"));
		Thread.sleep(1000);
		amt.click();
		Thread.sleep(1000);
		amt.sendKeys(string);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Pay Now']//parent::button")).click();

		Thread.sleep(1000);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
