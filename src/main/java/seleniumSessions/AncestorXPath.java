package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AncestorXPath {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.espncricinfo.com/series/australia-under-19s-in-india-2024-25-1450208/india-under-19s-vs-australia-under-19s-1st-unofficial-test-1450217/full-scorecard");
		Thread.sleep(4000);
		
		System.out.println(getWicketTakerName("Riley Kingsell")); 
		

	}
	
	public static String getWicketTakerName(String playername)
	{
		return driver.findElement(By.xpath("(//span[contains(text(),'"+playername+"')]/ancestor::td/following-sibling::td)[1]")).getText();
	}

}
