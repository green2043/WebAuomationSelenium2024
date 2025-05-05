package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath2IMP {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
//		((//htmlTag[contains(@attribute,'value')])[last()]//htmlTag)[last()]"))
		WebElement lastElement= driver.findElement(By.xpath("((//div[contains(@class,'navFooterLinkCol ')])[last()]//a)[last()]"));
		
		System.out.println(lastElement.getText());
		
		lastElement.click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		
		

	}

}
