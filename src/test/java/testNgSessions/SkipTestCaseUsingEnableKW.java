package testNgSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SkipTestCaseUsingEnableKW {
	
	WebDriver driver;
	
	
	//Default suite
	//Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
	
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
		System.out.println("page title:" + title);
		
		Assert.assertEquals(title, "Account Login","....open cart login page title is incorrect....");
	}
	
	@Test (description = "open cart forgot pwd test",enabled = false) // This TC won't execute
	public void forgotPwdLinkExistTest()
	{
		boolean flag= driver.findElement(By.linkText("Forgotten Password")).isDisplayed();
		Assert.assertEquals(flag, true,"....forgot pwd link is not present...");
	}
	
	@Test (description = "open cart logo test")
	public void logoTest()
	{
		boolean flag= driver.findElement(By.cssSelector("div#logo img")).isDisplayed();
		Assert.assertEquals(flag, true,"...logo is not present...");
	}
	

	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
