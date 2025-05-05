package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWndowPopUp {
	
		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			driver = new ChromeDriver();
			driver.get("https://www.zomato.com/");
			
			//<a href="https://in.linkedin.com/company/zomato" target="_blank" class="sc-elhb8j-17 iDzUMo">
			//if you get any target="_blank" attribute then understand if you click that element, it will open in new window
			//that's an window pop-up for you, for that you need to use 'WINDOW HANDLER API' in selenium.
			
			WebElement linkedIn = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
			linkedIn.click();
			
			//child window opens
			//switch driver to child window or child window pop-up
			
			Set<String> windowHandles = driver.getWindowHandles(); //Set is another collection which can't have any duplicate values
			Iterator<String> iter = windowHandles.iterator();
			
			String parentWindowID = iter.next();
			System.out.println("parent window id: "+" "+parentWindowID);
			
			String childWindowID = iter.next();
			System.out.println("child window id: "+" "+childWindowID);
			
			//System.out.println(windowHandles);
			driver.switchTo().window(childWindowID);
			System.out.println("child window url:"+" " +driver.getCurrentUrl());
			
			driver.close(); //only close the child window
			
//			driver.quit(); //will close all window
			
			//switch back to paernt window
			
			driver.switchTo().window(parentWindowID);
			System.out.println("parent window url:"+" " +driver.getCurrentUrl());
			
			driver.quit();
			
			
			
	}

}
