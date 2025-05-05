package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageTest {

	public static void main(String[] args) {
		
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.lunchBrowser("chrome");
		browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println(driver.getTitle());

		  By firstName = By.id("input-firstname"); 
		  By lastName = By.id("input-lastname"); 
		  By email = By.id("input-email");
		  By telephoneNum = By.id("input-telephone");
		  By newPassword = By.id("input-password");
		  By confirmPasswordBy=  By.id("input-confirm");

		ElementUtil elementUtil = new ElementUtil(driver);
		
		elementUtil.doSendKeys(firstName,"fname");
		elementUtil.doSendKeys(lastName,"lname");
		elementUtil.doSendKeys(email,"xy@abc.com");
		elementUtil.doSendKeys(telephoneNum,"4344686");
		elementUtil.doSendKeys(newPassword,"asd!@#123");
		elementUtil.doSendKeys(confirmPasswordBy,"asd!@#123");

		browserUtil.quitBrowser();
	}

}
