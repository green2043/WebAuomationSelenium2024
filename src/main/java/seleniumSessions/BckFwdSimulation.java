package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BckFwdSimulation {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		  driver.get("https://www.google.com"); 
		  System.out.println(driver.getTitle());
		 
		
		/*
		 * driver.navigate().to("https://www.google.com");
		 * System.out.println(driver.getTitle());
		 * THIS ALSO WORK
		 */
		
		driver.navigate().to("https://www.amazon.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh(); //refresh the page
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
