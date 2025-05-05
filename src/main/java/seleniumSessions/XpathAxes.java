package seleniumSessions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class XpathAxes {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://app.hubspot.com/login");
		
		
//		1.Parent to direct child:
		//htmlTagOfParent[@atributeOfparent='valueP']/htmlTagOfChild[@atributeOfChild='valueC']
		
		driver.findElement(By.xpath("//div[@class='private-form__input-wrapper']/input[@id='username']")).sendKeys("test@gmail.com");
		
//		2.Child keyword: //htmlTagOfParent[@atributeOfparent='valueP']/child::htmlTagOfChild[@atributeOfChild='valueC']		
		driver.findElement(By.xpath("//div[@class='private-form__input-wrapper']/child::input[@id='password']")).sendKeys("test!@#123");
	
		
//		3.Parent to indirect child: //htmltagOfparent[@attribute='value']//htmlTagOfIndirectChild[@attribute='value']
		Thread.sleep(2000);		
		WebElement element = driver.findElement(By.xpath("//form[@id='hs-login']//i18n-string[text()='Forgot my password']"));
		System.out.println(element.getText());
		
//		4.Child to Parent:  //htmlTagOfChild[@attributr='value']/..
		WebElement child = driver.findElement(By.xpath("//input[@id='username']"));
		System.out.println("child"+" : "+child.getTagName());
		WebElement firstParent = driver.findElement(By.xpath("//input[@id='username']/.."));
		System.out.println("First Parent"+" : "+firstParent.getTagName());
		WebElement secondParent = driver.findElement(By.xpath("//input[@id='username']/../.."));
		System.out.println("parent of first parent"+" : "+secondParent.getTagName());
		WebElement thirdParent = driver.findElement(By.xpath("//input[@id='username']/../../.."));
		System.out.println("parent of second parent"+" : "+thirdParent.getTagName());
		
//      5. Parent Keyword- //htmlTagOfParent[@atributeOfparent='valueP']/parent::htmlTagOfParent[@atributeOfParent='valueP']	
//     	OR                //htmlTagOfParent[@atributeOfparent='valueP']/parent::htmlTagOfParent
		WebElement immediateParent = driver.findElement(By.xpath("//input[@id='username']/parent::div"));
		System.out.println("immediateParent"+" : "+immediateParent.getTagName());
		
//		6. Sibling to previous Sibling(preceding-sibling):		
//		//htmlTagofSibling[@attribute='value']/preceding-sibling::htmlTagOfPrevoiusSibling[@attribute='value']		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement firstSibling = driver.findElement(By.xpath("//input[@id='input-email']/preceding-sibling::label[@class='control-label']"));
		System.out.println(firstSibling.getTagName());
		
//		6.  Sibling to next Sibling(following-sibling):
		//htmlTagofSibling[@attribute='value']/following-sibling::htmlTagOfNextSibling[@attribute='value']
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(2000);
		WebElement nextSibling = driver.findElement(By.xpath("//label[text()='E-Mail Address']/following-sibling::input[@id='input-email']"));
		System.out.println(nextSibling.getText());
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		//htmlTagofSibling[text()='value']/following-sibling::htmlTagOfNextSibling//htmlTagOfIndirectChild
		/*
		  List<WebElement> elementList = driver.findElements(By.xpath("//div[text()='Get to Know Us']/following-sibling::ul//a")); 
		  String text = "careers"; boolean flag = false; 
		  for(WebElement e : elementList) 
		  { if

		  (e.getText().equalsIgnoreCase(text)) {
		 
		  System.out.println(e.getText()); 
		  e.click(); 
		  flag=true; 
		  break; 
		  } 
		  } 
		  if(!flag) {
		  System.out.println("element not present in the list"); 
		  }
		 */	
		List<WebElement> elementList = driver.findElements(By.xpath(getXpath("Get o Know")));
		String text = "careers"; 
		boolean flag = false; 
		  for(WebElement e : elementList) 
		  { if (e.getText().equalsIgnoreCase(text)) 
		  {
		  System.out.println(e.getText()); 
		  e.click(); 
		  flag=true; 
		  break; 
		  } 
		  } 
		  if(!flag) {
		  System.out.println("element not present in the list"); 
		  }
		
 
	}
	
	public static String getXpath(String headerName)
	{
		String xpath = "//div[text()='"+headerName+"']/following-sibling::ul//a";
		return xpath;
		
	}
	

}
