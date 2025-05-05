package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {


		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.lunchBrowser("chrome");
		browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		ElementUtil elementUtil = new ElementUtil(driver);

		elementUtil.doSendKeys(emailId,"xyz@abc.com");
		elementUtil.doSendKeys(password,"abc123");

		browserUtil.quitBrowser();
	}

}
