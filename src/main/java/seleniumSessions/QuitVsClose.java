package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();// open Browser --123
		driver.get("https://www.google.com");// launch url

		String title = driver.getTitle();// get the title of page
		System.out.println("title:" + " " + title);

		String currentUrl = driver.getCurrentUrl();
		System.out.println("current Page Url:" + "  " + currentUrl);

//		driver.quit(); // close the browser not server//123
//		System.out.println(driver.getTitle());
//		// org.openqa.selenium.NoSuchSessionException: Session ID is null.
//		// Using WebDriver after calling quit()?
//
		driver.close(); // close the browser//123
//		System.out.println(driver.getTitle());
//		org.openqa.selenium.NoSuchSessionException: invalid session id

		// lunch browser again
		driver = new ChromeDriver();// 456
		driver.get("https://www.google.com");// 456
		System.out.println("title:" + " " + driver.getTitle());// 456
	}

}
