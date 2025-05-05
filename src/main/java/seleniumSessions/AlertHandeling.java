package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandeling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(4000);
		
		//pop-ups can't be inspect
		Alert alert =  driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
	  //alert.sendKeys("1234asdf");
		alert.accept();
	  //alert.dismiss();  // i.e : manually press esc key
		
//    in JS there is always one po-up at a time and one sendkeys text field
		
		// ADVERTISING POP-UPs ARE BROWSER WINDOW POP-UPS NOT JS ALERTS
		
	}
	
	

}
