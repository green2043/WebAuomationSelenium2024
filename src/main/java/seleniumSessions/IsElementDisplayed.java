package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By search = By.name("search");
		By logo = By.className("img-responsive");
		By logoByXpath = By.xpath("//img[@title='naveenopencart']");
		
//		if(doIsEleDisplayed(search)) {System.out.println("PASS");}
//		if(doIsEleDisplayed(logo)) {System.out.println("PASS");}
		
//		int count= driver.findElements(search).size(); 
//		if (count==1) {System.out.println("ELEMENT IS DISPLAYED");	}
//		else {System.out.println("ELEMENT IS NOT DISPLAYED");	}
		
		//selenium always gives the elements which visible in page, not hidden elements, E.g: dropdown and it's child elements unless expanded
		
//		if (IsSingleElementexist(search)) { System.out.println("ELEMENT IS DISPLAYED");}
//		if (IsSingleElementexist(logo)) { System.out.println("ELEMENT IS DISPLAYED");}
//		if (IsSingleElementexist(logoByXpath)) { System.out.println("ELEMENT IS DISPLAYED");}
		if (IsMultipleElementexist(search,3)) { System.out.println("ELEMENT IS DISPLAYED");}
		else {
			System.out.println("FAIL");
		}
		Thread.sleep(1000);
		driver.quit();

	}
	
	public static boolean IsSingleElementexist(By locator) {
		int actCount= getElements(locator).size();
		System.out.println("actual count of element ="+ actCount);
		if (actCount==1) {
			return true;
			
		} 
			return false;
		
		//without isDisplayed method
	}
	public static boolean IsTwoElementexist(By locator) {
		int actCount= getElements(locator).size();
		System.out.println("actual count of element ="+"   "+actCount);
		if (actCount >1) {
			return true;
			
		} 
			return false;
		 
		//without isDisplayed method
	}
	public static boolean IsMultipleElementexist(By locator, int expectedElementCount) {
		int actCount= getElements(locator).size();
		System.out.println("actual count of element ="+"   "+ actCount);
		if (actCount==expectedElementCount) {
			return true;
			
		} 
			return false;
		
		//without isDisplayed method
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}
	
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);		
	}
	public static boolean doIsEleDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

}
