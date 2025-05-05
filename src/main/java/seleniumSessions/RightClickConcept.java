package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).build().perform();
		
		List<WebElement> menuItems= driver
				.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]/span"));
		System.out.println(menuItems.size());
		for(WebElement e: menuItems)
		{
			String text = e.getText();
			System.out.println(text);
			if (text.equalsIgnoreCase("copy")) 
			{
				e.click();
				break;
			}
//			else {
//				System.out.println("element not found in context menu");
//			}
		}
		
		

	}

}
