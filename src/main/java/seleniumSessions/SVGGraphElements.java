package seleniumSessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//svg element can't locate using CSS selector
		 driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Navigate to the URL
        driver.get("https://petdiseasealerts.org/forecast-map/#/giardia/dog/united-states");
        Thread.sleep(2000);

        // Switch to the iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
        Thread.sleep(2000);

        // Define the XPath for the SVG elements
        String xpathForSVG = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']";
        List<WebElement> statesList = driver.findElements(By.xpath(xpathForSVG));
        System.out.println("Number of SVG elements found: " + statesList.size());

        Actions act = new Actions(driver); 
        JavascriptExecutor js = (JavascriptExecutor) driver; 

        // Loop through each state element in the list
        for (WebElement e : statesList) {
            String nameOfState = e.getAttribute("name"); 
            System.out.println("State: " + nameOfState); 

            // Scroll the element into view using JavaScript
           js.executeScript("arguments[0].scrollIntoView(true);", e);
         // Move to the element
            act.moveToElement(e).build().perform();
            
            // If the state is Maryland, click on it using JavaScript
            if ("Maryland".equals(nameOfState)) 
            {
            	// Dispatch a mouse click event using JavaScript
                js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true}));", e);          	          
                break; // Exit the loop after clicking Maryland
            }
        }
        
      //svg element can't locate using CSS selector

	}

}
