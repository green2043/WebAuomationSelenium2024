package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeBrowser {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.manage().deleteAllCookies(); //always good practice to delete cookies after launching domain

		driver.manage().window().maximize(); // maximize the browser
		Thread.sleep(1000);
		driver.manage().window().fullscreen(); // make browser full screen of monitor
		Thread.sleep(1000);
		driver.manage().window().minimize(); //minimize the browser
		
		
		driver.quit();

	}

}
