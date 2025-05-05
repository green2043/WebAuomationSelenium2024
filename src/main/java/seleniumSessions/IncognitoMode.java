package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		//options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		// Check if the browser is in incognito mode
		/*THIS JAVASCRIPT CHECKS FOR THE PRESENCE OF WEBKITREQUESTFILESYSTEM OR 
        REQUESTFILESYSTEM, WHICH ARE TYPICALLY AVAILABLE IN INCOGNITO MODE.
      */
        boolean isIncognito = (Boolean) ((JavascriptExecutor) driver).executeScript(
            "return window.webkitRequestFileSystem != null || window.RequestFileSystem != null;"
        		);

        System.out.println("Is Incognito: " + isIncognito);
		
		driver.quit();

	}

}
