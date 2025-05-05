package seleniumSessions;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		
		//page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("frame-one748593425");
		
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("xyz123");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Log in")).click();
	}

}
