package seleniumSessions;

import java.util.Iterator;
import java.util.List;

import org.checkerframework.checker.units.qual.radians;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TotalVluesInSelectDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/orangehrm-30-day-trial/");

		Thread.sleep(3000);

//		By country = By.id("Form_getForm_Country");
//		doSelectDropDpwnBy(country, "Canada");
		
		List<WebElement> countryList = driver.findElements(By.xpath("//Select[@id='Form_getForm_Country']/option"));
		
		for (WebElement e: countryList)
		{
			String text = e.getText();
			if (text.contains("India")) 
			{
				e.click();
				break;
				
			}
		}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectDropDpwnBy(By locator, String value) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

			if (text.contains(value)) {
				e.click();
				break;

			}
		}

	}

}
