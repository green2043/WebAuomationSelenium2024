package testNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTestUsingDataProvider extends BaseTest {

	@DataProvider
	public Object [][] getSearchData()
	{
		/*
		 In Java, a 2D object array is essentially an array of arrays.
		  Think of it as a table with rows and columns, 
		  like an Excel spreadsheet. Each element in this "table" can hold an object.
		 */
		return new Object[][]  // two dimension object array
				{
				
				{"macbook"},
				{"ipad"},
				{"samsung"},
				{"Apple"}
				
		};
	}
	
	@Test(dataProvider = "getSearchData")
	public void searchTest(String productName)
	{
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(productName);
		driver.findElement(By.cssSelector("#search button")).click();
		String results=driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(results.contains(productName));
	}
	
}