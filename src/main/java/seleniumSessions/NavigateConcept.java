package seleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateConcept {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();// open Browser

		//driver.navigate().to("https://www.google.com");
		
		driver.navigate().to(new URL("https://www.google.com"));
		/*
		 * URL is not a data type it's a class 
		 * get("string"), navigate.to("string"),navigate.to(new URL("string"))...all three works same
		 */
		
		/*
		 * driver.get("https://www.google.com"); 
		 * Synonym for org.openqa.selenium.WebDriver.Navigation.to(String).
		 * get() very straight forward method
		 */

		String title = driver.getTitle();// get the title of page
		System.out.println("Page title:" + " " + title);// print title in console

		// validation point/checkpoint/act vs exp
		if (title.equalsIgnoreCase("google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		driver.quit();

	}

}
