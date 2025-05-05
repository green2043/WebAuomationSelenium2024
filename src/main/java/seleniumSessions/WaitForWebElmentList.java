package seleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWebElmentList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com");
		
		By footer = By.xpath("//ul[@class='sc-ace17a57-0 sc-808d9567-1 kTjuIu dWgHtb']//a");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	List<WebElement> footerList= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer)); //return type is List
//	
//	System.out.println(footerList.size()); //25	
		
		int footerCount= waitForElementsVisibility(footer, 10).size();
		System.out.println(footerCount);

	}
	
	public static List<WebElement> waitForElementsVisibility(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	public static List<WebElement> waitForElementsPresence(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}

}
