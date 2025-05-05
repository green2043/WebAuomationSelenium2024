package testNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCart extends BaseTest {
	
	
	@Test(priority = 1)
	public void titleTest()
	{
		
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}
	
	@Test(priority = 2)
	public void searchExistTest()
	{
		Assert.assertEquals(driver.findElement(By.name("search")).isDisplayed(), true);
	}
	
	
	
	
	

}
