package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	
		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			driver = new ChromeDriver();
			driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
			
			WebElement sourceEle = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement targetEle = driver.findElement(By.xpath("//div[@id='droppable']"));
			
			Actions act = new Actions(driver);
			//act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
			act.dragAndDrop(sourceEle, targetEle).build().perform();
			
	}

}
