package seleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Navigate to the URL
        driver.get("https://www.aqi.in/dashboard/india");
        Thread.sleep(4000);
        
        WebElement element = driver.findElement(By.linkText("Noida, India"));
        
       // check what is the right side of 'element'
     String rightIndex =   driver.findElement(((RelativeBy) with(By.tagName("p"))).toRightOf(element)).getText();
     System.out.println(rightIndex);
     
     // check what is the left side of 'element'
     String leftIndex =   driver.findElement(((RelativeBy) with(By.tagName("p"))).toLeftOf(element)).getText();
     System.out.println(leftIndex);
     
     // check what is the below of 'element'
     String belowCity =   driver.findElement(((RelativeBy) with(By.tagName("p"))).below(element)).getText();
     System.out.println(belowCity);
     
     // check what is the above of 'element'
     String aboveCity =   driver.findElement(((RelativeBy) with(By.tagName("p"))).above(element)).getText();
     System.out.println(aboveCity);
     
     
     // check what is the near of 'element'  ---Not that much important
     String nearElementText =   driver.findElement(((RelativeBy) with(By.tagName("p"))).near(element)).getText();
     System.out.println(nearElementText);
       

	}

}
