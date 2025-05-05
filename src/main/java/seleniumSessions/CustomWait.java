package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	static WebDriver driver;

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement retryingElement(By locator, int timeOut)

	{
		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {

				element = getElement(locator);
				System.out.println("Element is found in attempt: " + attempts);
				break;

			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempt: " + attempts + "  for  " + locator);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}

			attempts++;

		}

		if (element == null) {

			System.out.println(
					"element is not found.....tried for : " + timeOut + " secs " + "with the interval of 1 sec");
			throw new FrameworkException("TimeOutException");

		}

		return element;

	}
	public static WebElement retryingElement(By locator, int timeOut,int interval)
	
	{
		WebElement element = null;
		int attempts = 0;
		
		while (attempts < timeOut) {
			try {
				
				element = getElement(locator);
				System.out.println("Element is found in attempt: " + attempts);
				break;
				
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempt: " + attempts + "  for  " + locator);
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
			}
			
			attempts++;
			
		}
		
		if (element == null) {
			
			System.out.println(
					"element is not found.....tried for : " + timeOut + " secs " + "with the interval of 1 sec");
			throw new FrameworkException("TimeOutException");
			
		}
		
		return element;
		
	}
	

	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com");
		
		
		By browseCarsBtn = By.xpath("//div[normalize-space()='Browse all carss']");
		
		
		//retryingElement(browseCarsBtn, 20).click();
		retryingElement(browseCarsBtn, 20, 2000).click();
		

	}

	public  void waitForPageLoad(int timeOut)
	{

		long endTime = System.currentTimeMillis()+timeOut;
		
		while(System.currentTimeMillis()<endTime)
		{
			JavascriptExecutor js= (JavascriptExecutor)driver;
			String pageState=	js.executeScript("return document.readyState").toString();
			if(pageState.equalsIgnoreCase("complete"))
			{
				System.out.println("page DOM is fully loaded....");
				break;
			}
			
		}
	}
	
	
}
