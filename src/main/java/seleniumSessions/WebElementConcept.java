package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// Create web element + perform action on it-> click, sendKeys, getText,
		// isDisplayed etc.

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		/*
		 * 1. driver.findElement(By.id("input-email")).sendKeys("victor@gmail.com");
		 * driver.findElement(By.id("input-password")).sendKeys("victor@123");
		 */

		/*
		 * 2. WebElement emailId = driver.findElement(By.id("input-email")); WebElement
		 * password = driver.findElement(By.id("input-password"));
		 * emailId.sendKeys("victor@gmail.com"); password.sendKeys("victor@123");
		 */

		/*
		 * //3. By locator approach:
		 * 
		 * By emailId= By.id("input-email"); //not web element, only by locators By
		 * password= By.id("input-password");//not web element, only by locators
		 * WebElement email_ele = driver.findElement(emailId); //now created web
		 * elements and sending request to server WebElement password_ele =
		 * driver.findElement(password); email_ele.sendKeys("victor@gmail.com");
		 * password_ele.sendKeys("victor@123");
		 */

		/*
		 * //4. By locator + generic function -> getElement() By emailId=
		 * By.id("input-email"); By password= By.id("input-password");
		 * getElement(emailId).sendKeys("victor@gmail.com");
		 * getElement(password).sendKeys("victor@123");
		 */

		/*
		 * //5. By locator+generic function -> getElement and action methods: By
		 * emailId= By.id("input-email"); By password= By.id("input-password");
		 * doSendKeys(emailId, "victor@gmail.com"); doSendKeys(password, "victor@123");
		 */

		// 6. By locator(Object repo) +generic function -> getElement and action methods in a util
		// class
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId,"dsw@gmail.com");
		eleUtil.doSendKeys(password,"xyz");
		
		//7.: Create separate  generic util class & a test class with main() method...

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick (By locator)
	{
		getElement(locator).click();
	}

}
