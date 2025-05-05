package testNgSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependenceOnMethodWithAssertion {
	
WebDriver driver;
	
	
	
	//Assert - In TESTNG this 'Assert' is hard assertion, i.e: If Assertion fail, It won't execute next 1000 lines of codes
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
	}
	

	@Test (description = "open cart title test")
	public void titleTest()
	{
		String title= driver.getTitle();
		//System.out.println("page title:" + title);
		
		Assert.assertEquals(title, "Account Login11","....open cart login page title is incorrect....");
		System.out.println("page title:" + title);
		System.out.println("----End of testing----");
		
//Here First assertion fails , so that remaining codes won't execute, that's why single assertion recommended and TC should independent 
		
		boolean flag= driver.findElement(By.linkText("Forgotten Password")).isDisplayed();
		Assert.assertEquals(flag, true,"....forgot pwd link is not present...");
		
		 flag= driver.findElement(By.cssSelector("div#logo img")).isDisplayed();
		Assert.assertEquals(flag, true,"...logo is not present...");
	}
	
	
	

	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
