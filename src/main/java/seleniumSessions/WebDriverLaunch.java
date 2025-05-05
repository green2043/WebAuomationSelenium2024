package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverLaunch {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver1 = new ChromeDriver();

		/*
		 * WebDriver driver = new ChromeDriver(); 
		 * WebDriver driver1 = new ChromeDriver(); 
		 * WebDriver driver2 = new ChromeDriver();
		 * driver.get("https://www.google.com"); 
		 * 3 browser will open and only first browser will open google page
		 */

		/*
		 * WebDriver driver = new ChromeDriver(); 
		 * driver = new ChromeDriver(); 
		 * driver = new ChromeDriver(); 
		 * driver.get("https://www.google.com"); 
		 * driver.quit(); 
		 * In this case last browser will be pointed and rest garbage collection
		 */

		/*
		 * WebDriver driver = new ChromeDriver(); 
		 * driver = null; 
		 * driver = new ChromeDriver(); 
		 * driver = new ChromeDriver();
		 * driver.get("https://www.google.com"); 
		 * driver.quit(); 
		 * only 3rd work, rest garbage and null
		 */
		
		WebDriver driver2 = new ChromeDriver(); 
		WebDriver driver3 = new ChromeDriver();
		
		driver1.get("https://www.google.com"); 
		driver1 = driver2;
		driver2.get("https://www.amazon.com"); 
		driver2 = driver3;
		driver3.get("https://www.flipkart.com"); 
		
		driver1.manage().window().minimize();
		Thread.sleep(1000);
		driver2.manage().window().maximize();
		
		
		//driver1.quit(); //only google will close

	}

}
