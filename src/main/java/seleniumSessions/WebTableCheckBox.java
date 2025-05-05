package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableCheckBox {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);
		
		// XPath to locate an element based on the text of its child, 
		// then navigate to the parent, and finally to the preceding sibling of the parent.

		// General format parent to preceding-sibling of child:
		// //htmlTagOfChild[text()='value']/parent::htmlTagOfParent/preceding-sibling::htmlTagOfPrecedingSiblingOfParent/htmlTagOfChildOfPrecedingSiblingParent

		// Example:
		// Locate the input element in the preceding sibling <td> of the parent <td> of the <a> element with text 'Joe.Root'
		//driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input"));

		selectUserCheckBox("John.Smith"); 
		selectUserCheckBox("Joe.Root");

		getUsername("Garry White");

		
		
	}
	
	public static void selectUserCheckBox (String username)
	{
		driver.findElement(By.xpath("//a[text()='"+username+"']/parent::td/preceding-sibling::td/input")).click();
		
	}
	public static String getUsername (String userNametext)
	{
		return 
		driver.findElement(By.xpath("//td[text()='"+userNametext+"']/parent::tr/child::td/following-sibling::td/a[@rel='noopener']")).getText();
		
		
	}

}
