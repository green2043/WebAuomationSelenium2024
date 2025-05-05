package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandeling2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//div[@data-id='dweb-modal']//div[@data-id='auth-flow-section']//span[@role='presentation']"))
		.click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		List<WebElement> enabledDates= 
				driver.findElements(By.cssSelector("div.DayPicker-Day:not(.DayPicker-Day--outside):not(.DayPicker-Day--disabled)"));
		
		for(WebElement e: enabledDates)
		{
			System.out.println(e.getText());
		}
	}

}
