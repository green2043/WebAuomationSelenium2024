package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverbasics {

	public static void main(String[] args)
	{
		//1.Open Browser
		//System.setProperty("webdriver.chrmedriver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();//open Browser
		driver.get("https://www.google.com");//launch url
		String title = driver.getTitle();//get the title of page
		System.out.println("Page title:"+" "+title);//print title in console
		//validation/verification/checkpoint/act vs exp:
		if(title.equalsIgnoreCase("google"))
		{
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		//automation steps+verification/validation =>Automation testing
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current Page Url:"+"  "+currentUrl);
		
		String pgSource = driver.getPageSource();
		//System.out.println(pgSource);
		if (pgSource.contains("Copyright The Closure Library Authors.")) 
		{
			System.out.println("Present");
		} else 
		{
			System.out.println("absent");
		}
		
		
		
		
		driver.quit();
		//driver.close();
		

	}

}
