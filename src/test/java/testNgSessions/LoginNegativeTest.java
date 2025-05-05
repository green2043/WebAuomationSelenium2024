package testNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest {

	@DataProvider
	public Object[][] getLoginData() {
		/*
		 * In Java, a 2D object array is essentially an array of arrays. Think of it as
		 * a table with rows and columns, like an Excel spreadsheet. Each element in
		 * this "table" can hold an object.
		 */
		return new Object[][] // two dimension object array
		{

				{ "satya@gmail.com", "abc123" }, 
				{ "victor@gmail.com", "xyz456" }, 
				{ "john@gmail.com", "tyu789" },
				{ "Doe@gmail.com", "iop789" }, 
				{ "   ", "   " }

		};
	}

	@Test(dataProvider = "getLoginData")
	public void loginNegativeTest(String uid, String pwd) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(uid);

		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String errMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();

		Assert.assertTrue(errMsg.contains("No match for E-Mail Address and/or Password"));

	}

}
