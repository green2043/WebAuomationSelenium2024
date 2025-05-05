package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForURL_Alert {

	
	static WebDriver driver;
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		/**
		 TITLE:
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.linkText("Register")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Register"));
		
		
		 -- what will be the return type of until method:
		 Ans: until method will change the behavior depend on <V> (i.e any value of V) which depends on the ExpectedConditions. 
		       refer it's original method
		 
		
		System.out.println(driver.getTitle());
		
//		String actualTitle = waitForTitleContains("Register", 5);	
//		System.out.println(actualTitle);
		
		*/
		
		/*
		URL:
		driver.get("https://www.amazon.in/");
		
		
		driver.findElement(By.linkText("Careers")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("jobs"));
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://www.flipkart.com/");
		
				
//		String actualURL = waitForUrlContains("flipkart", 5);	
//		System.out.println(actualURL);
		 */
		
		//ALERT:
		//waiting for the alert and switching to the alert also
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); //here until return type changed to alert based on ExpectedConditions
		System.out.println(alert.getText());
		alert.accept();
			
		
	}
	
	public static Alert waitForAlertPresentAndSwitch(int timeout) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeOut) 
	{
		return waitForAlertPresentAndSwitch(timeOut).getText();
		
	}	
	
	public static void acceptAlert(int timeOut)  
	{
		waitForAlertPresentAndSwitch(timeOut).accept();
		
	}
	
	public static void dismissAlert(int timeOut) 
	{
		waitForAlertPresentAndSwitch(timeOut).dismiss();
		
	}
	
	public static void alertSendKeys(int timeOut,String value) 
	{
		waitForAlertPresentAndSwitch(timeOut).sendKeys(value);
		
	}
	
	public static  String waitForTitleContains(String titleFractionValue, int timeOut) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleFractionValue))) 
		{
			return driver.getTitle();
		}
		else {
			System.out.println("expected value is not visible...");
			return null;
		}
	}
	public static  String waitForTitleIs(String titleCompleteValue, int timeOut) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(titleCompleteValue))) 
		{
			return driver.getTitle();
		}
		else {
			System.out.println("expected value is not visible...");
			return null;
		}
	}
	public static  String waitForUrlContains(String urlFractionValue, int timeOut) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFractionValue))) 
		{
			return driver.getCurrentUrl();
		}
		else {
			System.out.println("expected value is not visible...");
			return null;
		}
	}
	public static  String waitForUrlIs(String urlCompleteValue, int timeOut) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(urlCompleteValue))) 
		{
			return driver.getCurrentUrl();
		}
		else {
			System.out.println("expected value is not visible...");
			return null;
		}
	}
	
	
	
	public  static  WebElement getElement(By locator) 
	{
		return driver.findElement(locator);
	}

}
