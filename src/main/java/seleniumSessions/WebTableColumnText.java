package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableColumnText {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);
		
		System.out.println(getUsername("Garry White")); 
		System.out.println(getUsername("Jordan Mathews")); 

	}
	
	public static String getUsername (String userNametext)
	{
		return 
		driver.findElement(By.xpath("//td[text()='"+userNametext+"']/parent::tr/child::td/following-sibling::td/a[@rel='noopener']")).getText();	
	}

}
