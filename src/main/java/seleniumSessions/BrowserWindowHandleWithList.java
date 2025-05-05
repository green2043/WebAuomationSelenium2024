package seleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleWithList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		Thread.sleep(5000);

		// String parentWindowId = driver.getWindowHandle();

		// 1
		WebElement LinkedInElement = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		LinkedInElement.click();

		// child window opens
		// switch driver to child window

		// 1st: capture the window Ids

		Set<String> handles = driver.getWindowHandles();
		
		//convert SET to LISt : i.e: from non order list to order list
		List<String> handleList = new ArrayList<String>(handles);
		
		String parentWdId = handleList.get(0);
		String childWdId = handleList.get(1);
		
		driver.switchTo().window(childWdId);
		System.out.println(driver.getTitle()+" :  "+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWdId);
		System.out.println(driver.getTitle()+" :  "+driver.getCurrentUrl());
		driver.quit();
		
		

	}

}
