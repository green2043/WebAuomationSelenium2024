package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlePractice {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		By JsAlert = By.xpath("//button[text()='Click for JS Alert']");
		By JsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
		By JsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
		
		driver.findElement(JsAlert).click();
		handleAlert("alert");
		
//		driver.findElement(JsConfirm).click();
//		handleAlert("confirm");
//		
//		driver.findElement(JsPrompt).click();
//		handleAlert("prompt");
//		
		

	}
	
	public static void handleAlert(String alertType)throws InterruptedException {
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		switch (alertType.toLowerCase())
		{
		case "alert": {
			
			alert.accept();
			Thread.sleep(2000);
			break;
		}
		case "confirm": {
			
			alert.accept();
			Thread.sleep(2000);
			break;
			
		}
		case "prompt": {
			
			alert.sendKeys("abcd");
			Thread.sleep(2000);
			alert.accept();
			break;
		}
		default:
			 System.out.println("Unknown alert type");
             break;
		}
		
	}

}
