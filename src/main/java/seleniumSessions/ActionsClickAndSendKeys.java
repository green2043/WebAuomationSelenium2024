package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(email),"satya@gmail.com").build().perform();
//		act.sendKeys(driver.findElement(password),"satya@123").build().perform();
//		act.click(driver.findElement(loginBtn)).build().perform();
		
		doActionSendKeys(email, "satya@gmail.com");
		doActionSendKeys(password, "satya@123");
		doActionsClick(loginBtn);
		

	}
	
	public static WebElement getElement(By locator) 
	{
		return driver.findElement(locator);
	}
	
	public static void doActionSendKeys(By locator, String value) {
		
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).build().perform();
		
	}
	
	private static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
		
	}
	
	
	/* when application is under developement or there is some bug or an element is overlapped (uninteractable), 
	 * in that case use actionClick or actinSendKey
	 * when normal sendKeys and click not working then go with these two actions methods
	 */

}
