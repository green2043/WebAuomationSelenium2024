package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllAlertsType {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		WebElement alertBtn= driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		WebElement confirmBtn =driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		WebElement promptBtn =driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		
		alertBtn.click();
		Alert alert1 =  driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println(alert1.getText());
		alert1.accept();
		Thread.sleep(4000);
		
		confirmBtn.click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println(alert2.getText());
		alert2.dismiss();
		Thread.sleep(4000);
		
		promptBtn.click();
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println(alert3.getText());
		alert3.sendKeys("hello testing accept");
		alert3.accept();
		Thread.sleep(4000);
		
		promptBtn.click();
		Alert alert4 = driver.switchTo().alert();
		Thread.sleep(4000);
		alert4.sendKeys("hello testing dismiss");
		Thread.sleep(4000);
		alert4.dismiss();
		Thread.sleep(4000);
	}

}
