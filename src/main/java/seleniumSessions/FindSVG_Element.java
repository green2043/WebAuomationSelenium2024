package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindSVG_Element {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
//		//*[local-name()='svg']//*[name()='htmlTag' and contains(@attribute,'value')
		String xpathForSVG = "//*[local-name()='svg']//*[name()='path' and contains(@d, 'M10.5 18C14.6421')]";		
		By svgSearchIcon = By.xpath(xpathForSVG);
		driver.findElement(By.name("q")).sendKeys("macbook pro");
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		act.click(driver.findElement(svgSearchIcon)).build().perform();
		//driver.findElement(svgSearchIcon).click();
		
		//svg element can't locate using CSS selector

	}

}
