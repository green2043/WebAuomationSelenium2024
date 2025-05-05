package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementConcept {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Navigate to the URL
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        
       JavascriptExecutor js =(JavascriptExecutor)driver;
       String script1 = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')";
       String mandatoryText = js.executeScript(script1).toString();
       System.out.println(mandatoryText);
       
       if (mandatoryText.contains("*")) 
       {
    	   System.out.println("This is a mandatory field");
		
	} else {
		System.out.println("not a mandatory field");
	}
        
       
       String script2 = "return window.getComputedStyle(document.querySelector(\"label[for='input-lastname']\"),'::before').getPropertyValue('content')";
       mandatoryText = js.executeScript(script2).toString();
       System.out.println(mandatoryText);
       
       if (mandatoryText.contains("*")) 
       {
    	   System.out.println("This is a mandatory field");
		
	} else {
		System.out.println("not a mandatory field");
	}
       
       String script3 = "return window.getComputedStyle(document.querySelector(\"label[for='input-telephone']\"),'::before').getPropertyValue('content')";
       mandatoryText = js.executeScript(script3).toString();
       System.out.println(mandatoryText);
       
       if (mandatoryText.contains("*")) 
       {
    	   System.out.println("This is a mandatory field");
		
	} else {
		System.out.println("not a mandatory field");
	}
       

	}

}
