package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassNameConcept {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Navigate to the URL
        driver.get("https://app.hubspot.com/login");
        Thread.sleep(4000);
        
        By.xpath("//input[@class='form-control private-form__control login-email']");//valid ----> always use all multiple class
        By.xpath("//input[@class='form-control private-form__control']");//valid
        By.className("form-control private-form__control login-email");//invalid   ----> you can't use all class name together in classname locator
        By.className("private-form__control login-email");//invalid   ----> you can't use multiple class name together in classname locator
        By.className("private-form__control");//valid   
        By.className("login-email");//valid
        By.cssSelector(".form-control.private-form__control.login-email");//valid
		
		
		
		

	}

}
