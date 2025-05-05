package testNgSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	WebDriver driver;

	
	@Parameters({"url","browser"})
	@BeforeTest
	public void setUp(String url,String browserName)
	{
		System.out.println("launching browser : " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(url);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
