package seleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//ImplicitlyWait: Dynamic wait
		// timeout =10 secs,---> loaded in 2 secs,----> 8 secs will be cancelled
		
		//applicable only for web elements
		// it will be applied for all web elements by default once it declared
		//not applicable for non web elements: alerts, title, urls etc.
		//its a global wait
		
		driver = new ChromeDriver();
		
		//selenium 3.x:
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//selenium 4.x:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//home page: 10 secs
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		
		WebElement e1 = driver.findElement(By.linkText("MacBook"));
		System.out.println(e1.getAttribute("href"));
		
		//e2
		//e3
		//e4
		
		//now moving to login page: 20 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//e5.e6,e7,e8  : 2o secs 
		
		//now moving to home page: 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//e1,e2,e3,e4,e5: 15 secs
		
		//now moving to registration page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//e1,e2,e3,e4,e5: 5 secs
				
		//now moving to product page: 0 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//e1,e2,e3,e4,e5: 0 secs
		
		

	}

}
