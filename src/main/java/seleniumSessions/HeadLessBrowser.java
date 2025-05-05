package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowser {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//headless: no browser display
		//testing is happening behind the scene
		//faster than normal mode  : won't take time to lunch browser and all, But everything will happen background
		
		//htmlUnit was a 3rd party library, no we are not using it, it's not a browser,it's a separate project now
		//phantomJS also popular 7-8 years ago-also called ghostDriver, where browser won't lunch but things will happen background
		
		/*setHeadless(boolean) METHOD HAS BEEN DEPRECATED AND REMOVED IN RECENT VERSIONS OF SELENIUM, 
		 INCLUDING 4.24.0. INSTEAD, YOU SHOULD USE THE ADDARGUMENTS METHOD TO ENABLE HEADLESS MODE.
		 
		    UPDATED APPROACH
			You can enable headless mode by adding the --headless argument to ChromeOptions*/
		//optionsoptions.setHeadless(true); // setHeadless(boolean) METHOD HAS BEEN DEPRECATED AND REMOVED IN RECENT VERSIONS OF SELENIUM
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // Enable headless mode
		
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		/*
		 headless browser testing is not recommended- because from end user POV it's not good and real testing
		 another disadvantage, while in headless testing and if some JS pop-up will appear then Selenium might miss & give error 
		 */

	}

}
