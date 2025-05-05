package testNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		
		Assert.assertEquals(driver.getTitle(),
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority = 2)
	public void searchExistTest() {
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='nav-logo']")).isDisplayed(), true);
	}

}
