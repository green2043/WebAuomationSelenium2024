package seleniumSessions;

import java.io.NotActiveException;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		ElementUtil eleUtil = new ElementUtil(driver);

		// 1. ID: always unique attribute

		/*
		 * //2. name: can be duplicate
		 * //driver.findElement(By.name("email")).sendKeys("testmail@gmail.com");
		 * 
		 * By emailId = By.name("email"); eleUtil.doSendKeys(emailId, "test@gmail.com");
		 */

		// 3. Class name: can be duplicate most of the time because of UI theme
		// driver.findElement(By.className("form-control")).sendKeys("testmail@gmail.com");

		
		/*
		 * //4. xpath: not an attribute...address of web element
		 * driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(
		 * "test@gmail.com");
		 * driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(
		 * "test123");
		 * driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")
		 * ).click();
		 * 
		 * 
		 * By emailId = By.xpath("//*[@id=\"input-email\"]"); By pwd =
		 * By.xpath("//*[@id=\"input-password\"]"); By loginBtn =
		 * By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		 * 
		 * eleUtil.doSendKeys(emailId, "test@gmail.com"); eleUtil.doSendKeys(pwd,
		 * "test123"); eleUtil.doClick(loginBtn);
		 */
		
		//5.CSS selector: not an attribute
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		
//		//6. link text:only for links: can be duplicate
//		driver.findElement(By.linkText("Register")).click();
//		By registerLink = By.linkText("Register");
//		eleUtil.doClick(registerLink);
		
		//7. partial link text : only for links: can be duplicate
		//driver.findElement(By.partialLinkText("Forgotten")).click();	
		
		//8. tag name: HTML tag: can be duplicate mostly : not frequently used
//		String header= driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
		By header = By.tagName("h2");
		String h2= eleUtil.doGetElementText(header);
		System.out.println(h2);
	}

}
