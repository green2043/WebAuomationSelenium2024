package seleniumSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindowConcept {

	static WebDriver driver;

	public static void main(String[] args) 
	{

		driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		By locator = By.xpath("//i[@alt='linkedin']");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		
		String parentWindow=itr.next();
		String childWindow=itr.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindow);
		
		
		
		
		

	}

}
