package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//EXPLICITLY WAIT: can be applied for a specific element, and it's not a global wait
		     //i. WebDriverWait -Class(C)
		    //ii. FluentWait -Class(C)
			//iii. can be applied for non web elements: alerts,urls, title
		
		//WebDriverWait(C)-->extends-->FluentWait(C)-->implements-->Wait(I)--until();
		                                //until(){}
		                                //other methods
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		/*
		  By macbook = By.linkText("MacBook"); 
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		  WebElement mac_ele =wait.until(ExpectedConditions.presenceOfElementLocated(macbook));
		 
		  mac_ele.click();
		 */
		
		/*
		  By macbook = By.linkText("ekshlb");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement mac_ele = wait.until(ExpectedConditions.presenceOfElementLocated(macbook));
		
		mac_ele.click(); 
		//TimeoutException and after 10 sec
		*/
		
		
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		waitForElementPresence(emailId, 5).sendKeys("satya@gmail.com");
		getElement(password).clear();
		getElement(password).sendKeys("abc@1234");
		getElement(loginBtn).click();

	}
	
	/**
	 * presenceOfElementLocated:
		An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		/*
		presenceOfElementLocated:
		An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that the element is visible.
		*/
	}
	
	/**
	 * visibilityOfElementLocated:
			An expectation for checking that an element is present on the DOM of a page and visible.
			Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		/* 
		 	visibilityOfElementLocated:
			An expectation for checking that an element is present on the DOM of a page and visible.
			Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
		 */
	}
	
	
	
	
	
	public  static  WebElement getElement(By locator) 
	{
		return driver.findElement(locator);
	}
	

}
