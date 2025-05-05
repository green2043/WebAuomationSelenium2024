package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get("https://www.myntra.com/");

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; String title =
		 * js.executeScript("return document.title").toString();
		 * System.out.println(title);
		 */
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		System.out.println(jsUtil.getTitleByJS());
		//System.out.println(jsUtil.getPageInnerText());
		
//		String pageText= jsUtil.getPageInnerText();
//		if(pageText.contains("Orchard Hotel Singapore"))
//		{
//			System.out.println("PASS");
//		}
//		
		
//		jsUtil.refreshBrowserByJS();
		
//		jsUtil.generateAlert("homepage displayed");
		
//		WebElement emailID= driver.findElement(By.id("input-email"));
//		jsUtil.drawBorder(emailID);
//		
//		WebElement rightPanel= driver.findElement(By.id("column-right"));
//		jsUtil.drawBorder(rightPanel);
//		
//		jsUtil.flash(emailID);
//		emailID.sendKeys("test@abc.com");
//		jsUtil.flash(rightPanel);
//		
		
//		jsUtil.scrollPageDown();   //bottom
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown("1000");  // down to specific height
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();  //top
//		Thread.sleep(2000);
		
//		WebElement ele = driver.findElement(By.xpath("//h4[text()='Shop By Category']"));
//		jsUtil.scrollIntoView(ele);
		
		
		WebElement ele = driver.findElement(By.linkText("Contact Us"));
		jsUtil.clickElementByJS(ele);
		
		
		
		
		//Selenium click() -- deals with visible elements only
		//Action click
		//JS click -- deals with dom element only not visible elements - 100% work but not recommended
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
 