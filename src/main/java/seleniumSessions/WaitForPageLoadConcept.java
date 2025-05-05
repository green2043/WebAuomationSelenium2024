package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitForPageLoadConcept {

	static WebDriver driver;
	
	public static void waitForPageLoad(int timeOut)
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
	
	
	public static void main(String[] args) 
	{
		driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		waitForPageLoad(10);
	}

}
