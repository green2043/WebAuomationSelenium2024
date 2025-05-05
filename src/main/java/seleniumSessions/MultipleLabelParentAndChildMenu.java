package seleniumSessions;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleLabelParentAndChildMenu {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		By parentMenuBy = By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']");
		selectlevel4MenuItem(parentMenuBy, "a", "Beverages", "Tea", "Green Tea");
		
		

	}
	
	
	
	
	
	public static void selectlevel4MenuItem(By parentMenulocator,String htmlTag, String level1Menu,String level2Menu,
			String level3Menu) throws InterruptedException 
	{
		WebElement parentMenu = driver.findElement(parentMenulocator);
		Actions act = new Actions(driver);
		act.moveToElement(parentMenu).build().perform();
		Thread.sleep(2000);
		act.click().perform();
		Thread.sleep(2000);
		
		WebElement l1Level = driver.findElement(By.xpath("(//"+htmlTag+"[text()='"+level1Menu+"'])[2]"));
		act.moveToElement(l1Level).build().perform();
		Thread.sleep(2000);
		
		// freeze a page by pressing Fn+F8 after inspecting the element and go to source tab
		
		WebElement l2Level = driver.findElement(By.xpath("(//"+htmlTag+"[text()='"+level2Menu+"'])[1]"));
		act.moveToElement(l2Level).build().perform();
		Thread.sleep(2000);
		
		WebElement l3Level = driver.findElement(By.xpath("(//"+htmlTag+"[text()='"+level3Menu+"'])[1]"));
		act.moveToElement(l3Level).build().perform();
		Thread.sleep(2000);
		act.click().perform();
		
		//driver.findElement(By.xpath("(//a[text()='Green Tea'])[1]")).click();
	}

}
