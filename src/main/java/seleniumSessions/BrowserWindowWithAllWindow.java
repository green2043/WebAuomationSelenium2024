package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowWithAllWindow {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		Thread.sleep(5000);
		
		String parentWindowId = driver.getWindowHandle();
		
		WebElement LinkedInElement = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		WebElement facebookElement = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement twitterElement = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement instagramElement = driver.findElement(By.xpath("//a[contains(@href,'instagram')]"));
		WebElement youtubeElement = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		
		LinkedInElement.click();
		facebookElement.click();
		twitterElement.click();
		instagramElement.click();
		youtubeElement.click();
		
		Set<String> handle = driver.getWindowHandles();  // SET doesn't maintain the order
		
		Iterator<String> itr = handle.iterator();
		
		while (itr.hasNext())
		{
			String windowID = itr.next();
			driver.switchTo().window(windowID);
			System.out.println(driver.getTitle()+" : "+driver.getCurrentUrl());
			//driver.close();
			Thread.sleep(2000);
			
			if(!windowID.equals(parentWindowId))
			{
				driver.close(); //Except parent window all window will close
			}
			
			
		}
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		
	}

}
