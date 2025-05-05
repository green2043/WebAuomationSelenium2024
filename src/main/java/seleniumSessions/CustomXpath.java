package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

static WebDriver driver;
	
	//VERY IMMPORTANT INTERVIEW QUESTION

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		/*
		1. ABSOLUTE XPATH
		/html/body/div[2]/div/div/div[2]/div[1]/div/div[1]/a
		
		
		2. CUSTOMXPATH XPATH OR RELATIVE XPATH
		  //htmlTag[@attribute ='value']
		  //htmlTag[@attribute1 ='value1' and @attribute2 ='value2']
		  //htmlTag[@attribute1 ='value1' or @attribute2 ='value2']
		  //htmlTag[text() ='value'] -- text is not an attribute, it's only text of element with an html tag
		  //htmlTag[text() ='value' and @attribute ='value'] 
		  //htmlTag[@attribute ='value'and text() ='value'] 
		  //htmlTag[contains(@attribute,'value or partial value')] 
		  //htmlTag[contains(text(),'value or partial value')] 
		  //htmlTag[contains(text(),'value or partial value')and contains(@attribute2,'value2')]
		  //htmlTag[starts-with(@attribute,'value')]
		  //htmlTag[starts-with(@attribte1,'value')and starts-with(@attribute2,'value')]
		  //htmlTag[starts-with(@attribte1,'value')and contains(@attribute2,'value or partial value')]
		   
		  //ends-with():NA
		   
		   */
		   
//		    INDEXING:
//		    ---------
//		    1.(//htlmTag[@attribute='value'])[1]
//		    -- if there are multiple elements then capture them in group using xpath inside brackets(), then put a number in sq bracket[]
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("indexing xpath [1]for firdt nsme");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("indexing xpath [2] for last name");
				    
		    
//		    2.(//htlmTag[@attribute='value'])[position()=1]
		driver.findElement(By.xpath("(//input[@class='form-control'])[position()=5]")).sendKeys("indexing xpath using function position()for password element");
		
		
//			3. (//htlmTag[@attribute='value'])[last()]		-- there is no first() function
		    
		driver.findElement(By.xpath("(//input[@class='form-control'])[last()]")).sendKeys("indexing xpath using function last()for password confirm element");
		    
//		    4.(//htlmTag[@attribute='value'])[last()-1]	   -- reverse way technique
		  
		driver.findElement(By.xpath("(//input[@class='form-control'])[last()-3]")).sendKeys("indexing xpath using function last()-3");
		
//			5. ((//htmlTag[contains(@attribute,'value')])[last()]//htmlTag)[last()]"))
		Thread.sleep(2000);		
		WebElement lastElementOfFoorter	= driver.findElement(By.xpath("(((//div[contains(@class,'row')])[last()]//div)[last()]//li)[last()]"));
		System.out.println(lastElementOfFoorter.getText());
		
//			6. //*[@attribute='value']     --not recommended, performance will be very slow
		
						
		

	}

}
