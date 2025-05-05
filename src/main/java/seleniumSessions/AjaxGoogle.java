package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjaxGoogle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		Thread.sleep(3000);
		
		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
		System.out.println(suggestionList.size());
		
		for (WebElement e: suggestionList)
		{
			String suggestionText= e.getText();
			System.out.println(suggestionText);
			
			if (suggestionText.contains("selenium testing")) 
			{
				e.click();
				break;
			}
		}

	}

}
