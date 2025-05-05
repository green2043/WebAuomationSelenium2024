package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForFrame {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/");
		driver.manage().window().maximize();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
		
		waitForFramePresentAndSwitch(2, 10);
		
		
		
		String headerText = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(headerText);
		
		driver.switchTo().defaultContent();

	}
	
	public static void waitForFramePresentAndSwitch(int frameInndex, int timeOut)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameInndex));
		
		
	}
	
	public static void waitForFramePresentAndSwitch(By frameLocator, int timeOut)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
		
	}
	
	public static void waitForFramePresentAndSwitch(WebElement frameElement, int timeOut)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		
		
	}
	
	public static void waitForFramePresentAndSwitch(String nameOrID, int timeOut)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
		
		
	}

}
