package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MoveToelementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com");

//		WebElement adddOns= driver.findElement(By.xpath("//div[text()='Add-ons']"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(adddOns).build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[text()='Student Discount']")).click();

		selectSubMenu("div","SpiceClub", "Tiers");

		Thread.sleep(1000);
		driver.quit();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	

	public static void selectSubMenu(String htmlTag, String parentMenu, String chilDmenu) throws InterruptedException {
		By parentMenuLocator = By.xpath("//"+htmlTag+"[text()='" + parentMenu + "']");
		By childMenuLocator = By.xpath("//"+htmlTag+"[text()='" + chilDmenu + "']");
		WebElement parentMenuelement = driver.findElement(parentMenuLocator);
		//WebElement childMenuelement = driver.findElement(childMenuLocatorBy);

		Actions act = new Actions(driver);
		act.moveToElement(parentMenuelement).build().perform();
		Thread.sleep(2000);

		doClick(childMenuLocator);

	}

}
