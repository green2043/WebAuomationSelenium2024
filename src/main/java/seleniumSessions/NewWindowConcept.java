package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		String parentWdId = driver.getWindowHandle();
		Thread.sleep(5000);
		
		//New feature in selenium 4+
//		driver.switchTo().newWindow(WindowType.TAB);  // new tab will open
//		driver.get("https://www.swiggy.com/");
//		Thread.sleep(5000);
//		System.out.println(driver.getTitle());
//		driver.close();
		
		//New feature in selenium 4+
		driver.switchTo().newWindow(WindowType.WINDOW);  //New window will open
		driver.get("https://www.swiggy.com/");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.close();
		Thread.sleep(5000);
		
		driver.switchTo().window(parentWdId);
		System.out.println(driver.getTitle());
		driver.close();
		
		

	}

}
