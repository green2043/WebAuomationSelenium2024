package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HeadLessFramehandleWithAction {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//driver.get("https://ui.vision/demo/webtest/frames/");
		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		System.out.println(driver.getTitle());
		
		WebElement iframe0 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(iframe0);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
//		WebElement iframe1 = driver.findElement(By.xpath("//div[@class='iframe-container']/iframe"));
//		driver.switchTo().frame(iframe1);
		
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(iframe1);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
		
		Actions act = new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//input[@type='text']"));
		//WebElement ele2 = driver.findElement(By.xpath("//input[@jsname='YPqjbf']"));
		act.click(ele1).build().perform();
		act.sendKeys("test frame within frame").build().perform();
		Thread.sleep(1000);
//		act.moveToElement(ele2).sendKeys("test123").build().perform();
		
		// Switch back to the parent iframe
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());

        // Switch back to the main content
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());

        // Close the browser
        driver.quit();
		 

	}

}
