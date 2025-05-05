package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.NeedsLocalLogs;

public class CustomCssSelector {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		Thread.sleep(4000);
		
//		CSS = Cascade style sheet 
		
		//id --> #ValueOfid
		//class --> .ValueOfClass
		
		
		
		//id --> #ValueOfid
		//#input-email    --with Htmltag
		//input#input-email  --without Htmltag
		By.cssSelector("#input-email "); 
		By.cssSelector("input#input-email "); 
		
		//class --> .ValueOfClass
		By.cssSelector(".form-control"); 
		By.cssSelector("input.form-control"); //htmltag.ValueOfClass
		
		//#ValueOfid.ValueOfClass
		//.ValueOfClass#ValueOfid
		//htmlTag.ValueOfClass#ValueOfid
		//.ValueOfClass1.ValueOfClass2.ValueOfClass3.....ValueOfClassN
		By.cssSelector(".btn.btn-primary");
		//htmlTag.ValueOfClass1.ValueOfClass2.ValueOfClass3.....ValueOfClassN
		By.cssSelector("input.btn.btn-primary");
		
//		htmlTag[attribute='value']		
		By.cssSelector("input[type='email']");
		
//		htmlTag[attribute^='value']  ---> here '^' symbol is similar to 'starts with' keyword	
		By.cssSelector("input[id^='input']");
		
//		htmlTag[attribute^='value']  ---> here '$' symbol is similar to 'ends with' keyword	
		By.cssSelector("input[id$='email']");
		
//		htmlTag[attribute^='value']  ---> here '*' symbol is similar to 'contains' keyword	
		By.cssSelector("input[id*='email']");
		
// 		Child to parent: backward traversing not supported
		
//		Sibling in css: '+' used for following sibling
//		htmlTag[attribute='value']+htmlTagOfFollowingSibling[attribute='value']
		By.cssSelector("label[for='input-email']+input[name='email']");
		
//		COMMA in CSS: using comma (',') we can find multiple elements
//		htmltag1#id1,htmltag1#id2,htmltag3#id3,htmltag4#id4		
		
		//EXAMPLE:
		By mandatoryElwments = By.cssSelector("input#username,input#password,input#remember,button#loginBtn");
		driver.get("https://app.hubspot.com/login");
		int countelements = driver.findElements(mandatoryElwments).size();
		if (countelements==4) {
			System.out.println("mandatory elements are available on the page");
		} else {
			System.out.println("mandatory elements are not available on the page");
		}
		
//		Indexing in CSS:
//		htmlTag:nth-of-type(number) 		
//		htmlTag:nth-of-type(n) --> for all elements 		
		driver.get("https://amazon.com");
		driver.findElement(By.cssSelector("div.navFooterLinkCol  div.navFooterColHead+ul li:nth-of-type(5)")).click();
		

		

	}

}
