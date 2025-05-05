package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetTextFieldvalue {

	static WebDriver driver;
	
	//VERY IMMPORTANT INTERVIEW QUESTION

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement element = driver.findElement(By.id("input-email"));
		element.sendKeys("asasd@gmail.com");
		//String val = element.getText(); //it won't work
		String val = element.getAttribute("value"); //it will work
		System.out.println(val);

	}

}
