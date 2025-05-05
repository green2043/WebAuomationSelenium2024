package seleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverTopCastingOptions {
	 static WebDriver driver;

	public static void main(String[] args) {
		//A. Creating the object of browser for driver class
		//Valid top casting and we use it for local specific browser execution
		/*1.
		System.setProperty("webdriver.chrome.driver","/Location/Of/chromedriver");
		ChromeDriver driver = new ChromeDriver();*/
		
		/*2.
		 System.setProperty("webdriver.gecko.driver","/Location/Of/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();*/
		
		/*3.
		 System.setProperty("webdriver.gecko.driver","/Location/Of/edgedriver");
		EdgeDriver driver = new EdgeDriver()
		 */
		 
		//B.Top casting: can achive cross browser testing
		//valid top casting and can be use to run TCs locally
		/*String browser = "firefox";

		if (browser.contentEquals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browser.contentEquals("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if (browser.contentEquals("edge")) 
		{
			driver = new EdgeDriver();
		}
		else if (browser.contentEquals("safari")) 
		{
			driver = new SafariDriver();
		}
		else  
		{
			System.out.println("please pass the right browser...");
		}
		*/
		
		
		//C. WD= RWD : to run test cases at the remoteMachine/cloud/grid
		
		/*
		  driver = new RemoteWebDriver(remoteAddress, chromedriver);
		 */
		
		
		//D. SC = CD/FD/SD/ID : valid top casting but practically can't be use, only get and FE/FEs methods available
		/*
		 SearchContext sc = new ChromeDriver();
		 */
		
		
		//E. RWD = CD/FD/ID/ED
		//Valid top casting and can be used for local execution
		/*
		System.setProperty("webdriver.chrome.driver","/Location/Of/chromedriver");
		RemoteWebDriver driver = new ChromeDriver();
		*/
		RemoteWebDriver driver = new ChromeDriver();
		
		//F. SC = RWD
		//Valid but we don't use it.... it will access only FE/FEs
		/*
		SearchContext sc = new RemoteWebDriver(remoteaddress, capabilities);
		*/
		
		
		
		
		
		
		driver.get("https://www.google.com");// launch url
		String title = driver.getTitle();// get the title of page
		System.out.println("Page title:" + " " + title);// print title in console
		// validation/verification/checkpoint/act vs exp:
		if (title.equalsIgnoreCase("google")) 
		{
			System.out.println("correct title");
		} else 
		{
			System.out.println("incorrect title");
		}

		driver.quit();

	}

}
