package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/list-of-logical-programs-in-java");
		
		/*
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(10))
								.pollingEvery(Duration.ofSeconds(1))
								.ignoring(ElementNotInteractableException.class)
								.ignoring(NoSuchElementException.class)
								.ignoring(StaleElementReferenceException.class)
								.ignoring(ElementClickInterceptedException.class)
								.ignoring(TimeoutException.class)
								.withMessage("Element not found on the page");
//		WebElement ele	=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bottomnextup']//a[text()='next →']")));
//		ele.click();
		WebElement ele	=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bottomnextup']//a[text()='next11 →']")));
		ele.click();
		//TimeoutException: Expected condition failed: Element not found on the page (tried for 10 second(s) with 1000 milliseconds interval)
		
		
		*/
		
		waitForElementtoBeVisible(By.xpath("//div[@id='bottomnextup']//a[text()='next11 →']"), 10, 1).click();
		//TimeoutException: Expected condition failed: Element not found on the page (tried for 10 second(s) with 1000 milliseconds interval)
		
	}
	
	public static WebElement waitForElementtoBeVisible (By locator,int timeOut,int intervalTime )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofSeconds(intervalTime));
		wait.ignoring(NoSuchElementException.class)
		.ignoring(ElementNotInteractableException.class)
		.ignoring(TimeoutException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage("Element Not found on the page...");
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
}
