package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramehandleWithActionClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver.get("https://ui.vision/demo/webtest/frames/");
		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		WebElement iframe0 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(iframe0);
		Thread.sleep(2000);

//		WebElement iframe1 = driver.findElement(By.xpath("//div[@class='iframe-container']/iframe"));
//		driver.switchTo().frame(iframe1);

		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(iframe1);
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//input[@type='text']"));
		// WebElement ele2 = driver.findElement(By.xpath("//input[@jsname='YPqjbf']"));
		act.click(ele1).build().perform();
		act.sendKeys("test frame within frame").build().perform();
		Thread.sleep(1000);
//		act.moveToElement(ele2).sendKeys("test123").build().perform();

		// Switch back to the parent iframe
		driver.switchTo().parentFrame();

		// Switch back to the main content
		driver.switchTo().defaultContent();

		// Close the browser
		// driver.quit();

	}

}
