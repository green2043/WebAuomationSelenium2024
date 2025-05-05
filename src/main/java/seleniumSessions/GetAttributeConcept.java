package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
//	String	hrefvalue= driver.findElement(By.id("nav-logo-sprites")).getAttribute("href");
//	System.out.println(hrefvalue);
	
//	WebElement ele = driver.findElement(By.id("nav-logo-sprites"));
//	
//	String hrefvalString = ele.getAttribute("href");
//	String label = ele.getAttribute("aria-label");
//	
//	System.out.println(hrefvalString);
//	System.out.println(label);
	
//	WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
//	String typeValueString = ele.getAttribute("type");
//	System.out.println(typeValueString);
		
		By logo = By.id("nav-logo-sprites");
		
		ElementUtil elementUtil = new ElementUtil(driver);
		String attributeValue = elementUtil.doGetDomAttributeValue(logo, "href");
		System.out.println(attributeValue);
	
	}

}
