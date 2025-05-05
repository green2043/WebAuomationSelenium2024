package seleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

	WebDriver driver; // don't make the driver 'static',problem during parallel execution
	// it will store in common memory
	// during framework design don't make static

	public WebDriver lunchBrowser(String browserName) {
		System.out.println("browser name is  :" + "  " + browserName);

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("please pass the right browser:" + " " + browserName);
			break;
		}

		return driver;

	}

	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("URL IS NULL");
			throw new FrameworkException("URL_IS_NULL");
		}

		if (url.length() == 0) {
			System.out.println("URL IS BLANK");
			throw new FrameworkException("URL_IS_BLANK OR URL_IS_EMPTY");
		}

		/*
		 * if (url.indexOf("hhtp") != 0 || url.indexOf("https") != 0) // OR = ||, And =
		 * && { System.out.println("http(s) is missing in url"); throw new
		 * FrameworkException("HTTP(S)_IS_MISSING"); }
		 * 
		 * OR OPERATOR IS NOT SUITABLE, ONE CONDITION IS MATCHED AND OTHER NOT MATCHED
		 * 
		 */

		
		  if (url.indexOf("hhtp")!=0 && url.indexOf("https")!=0) {
		  System.out.println("http(s) is missing in url"); 
		  throw new FrameworkException("HTTP(S)_IS_MISSING"); }
		  //AND OPERATOR IS SUITABLE , SATISFYING BOTH CONDITION, CAUSE HTTP IS PART OF HTTPS
		 
		driver.get(url);

	}
	public void launchUrl(URL url) {
		
		String newUrl= String.valueOf(url);
		if (newUrl == null) {
			System.out.println("URL IS NULL");
			throw new FrameworkException("URL_IS_NULL");
		}
		
		if (newUrl.length() == 0) {
			System.out.println("URL IS BLANK");
			throw new FrameworkException("URL_IS_BLANK OR URL_IS_EMPTY");
		}

		if (newUrl.indexOf("hhtp")!=0 && newUrl.indexOf("https")!=0) {
			System.out.println("http(s) is missing in url"); 
			throw new FrameworkException("HTTP(S)_IS_MISSING"); }
		//AND OPERATOR IS SUITABLE , SATISFYING BOTH CONDITION, CAUSE HTTP IS PART OF HTTPS
		
		driver.navigate().to(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void quitBrowser () {
		driver.quit();
	
	}
	public void closeBrowser () {
		driver.close();
		
	}

}
