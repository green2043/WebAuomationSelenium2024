package seleniumSessions;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglrLanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		By langLocatorBy = By.xpath("//div[@id='SIvCob']/a");
		// doClickOnElements(langLocatorBy,"मराठी");
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doClickOnElements(langLocatorBy, "मराठी");

	}

//	public static void doClickOnElements(By locator, String linkText) 
//	{
//
//		List<WebElement> languageLinks= driver.findElements(locator);
//		
//		System.out.println("total language links:" + languageLinks.size());
//		
//		for(WebElement e: languageLinks)
//		{
//			String text= e.getText();
//			System.out.println(text);
//			
//			if (text.contains(linkText))
//			{
//				e.click();
//				break;
//			}
//		}
//		
//	}

}
