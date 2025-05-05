package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleOneByOne {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		Thread.sleep(5000);
		
		//String parentWindowId = driver.getWindowHandle();
		
		//1	
		WebElement LinkedInElement = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		LinkedInElement.click();
		//child window opens
		//switch driver to child window
		
		//1st: capture the window Ids
	  	Set<String> handles = driver.getWindowHandles();
	  	Iterator<String> itr = handles.iterator();
	  	
	  	String parentWindowId = itr.next();
	  	String childWindowId = itr.next();
	  	
	  	driver.switchTo().window(childWindowId);
	  	System.out.println(driver.getCurrentUrl());
	  	driver.close();
	  	driver.switchTo().window(parentWindowId);
	  	System.out.println(driver.getTitle());
	  	
	  	//2
	  	WebElement facebookElement = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
	  	
	  	facebookElement.click();
		
	  	Set<String> handles2 = driver.getWindowHandles();
	  	Iterator<String> itr2 = handles2.iterator();
	  	
	  	 parentWindowId = itr2.next();
	  	 childWindowId = itr2.next();
	  	
	  	driver.switchTo().window(childWindowId);
	  	System.out.println(driver.getCurrentUrl());
	  	driver.close();
	  	driver.switchTo().window(parentWindowId);
	  	System.out.println(driver.getTitle());
	  	
	  	driver.close();
	  	
	  	
 		

	}

}
