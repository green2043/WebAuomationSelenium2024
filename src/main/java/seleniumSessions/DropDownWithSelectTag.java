package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWithSelectTag {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		 driver = new ChromeDriver();
		driver.get("https://orangehrm.com/orangehrm-30-day-trial/");
		
		Thread.sleep(3000);
		
//	 	WebElement country = driver.findElement(By.id("Form_getForm_Country"));
//		Select select = new Select(country);
		
		//select.selectByIndex(5); //avoid: index value might be changed in future
		//select.selectByVisibleText("Bahrain"); //prefer this one, best option
		//select.selectByValue("Cambodia"); // when value attribute present
		
		//vale and visible text can be different
		
		By country = By.id("Form_getForm_Country");
		doSelectDropdownByIndex(country, 5);
		
		doSelectDropdownByVisibleText(country, "India");
		
		doSelectDropdownByValue(country, "Belgium");

	}
	
	public static void doSelectDropdownByIndex (By locator, int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropdownByVisibleText (By locator, String text)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectDropdownByValue (By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static WebElement getElement(By locator) 
	{
		return driver.findElement(locator);
	}

}
