package seleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderElement {

   

    	    @SuppressWarnings("deprecation")
    	    public static void main(String[] args) throws InterruptedException {
    	       
    	    	        // Setup ChromeDriver
    	    	        WebDriver driver = new ChromeDriver();
    	    	        
    	    	        // Step 1: Navigate to the FitPeo Homepage
    	    	        driver.get("https://www.fitpeo.com");
    	    	        driver.manage().window().maximize();
    	    	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	    	        
    	    	        // Step 2: Navigate to the Revenue Calculator Page
    	    	        driver.findElement(By.linkText("Revenue Calculator")).click();  // Adjust the locator based on actual link text or method to navigate

    	    	        // Step 3: Scroll Down to the Slider section
    	    	        WebElement sliderSection = driver.findElement(By.xpath("//input[@type='range']")); // Adjust the locator based on the actual section class or id
    	    	        Actions actions = new Actions(driver);
    	    	        actions.moveToElement(sliderSection).perform();
    	    	        Thread.sleep(1000); // Allow some time for the section to be in view

    	    	        // Step 4: Adjust the Slider to 820 using Actions class
    	    	        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
    	    	        WebElement textBox = driver.findElement(By.xpath("//input[contains(@id,'revenue')]"));  // Adjust the XPath to match the text box id

    	    	        // Use Actions class to reset the slider to 0
    	    	        actions.clickAndHold(slider).moveByOffset(-slider.getSize().width, 0).release().perform();
    	    	        Thread.sleep(500); // Allow some time for the value to reset

    	    	        int targetValue = 820;
    	    	        int currentValue = 0;
    	    	        int step = 5;  // Step size for incrementing the slider

    	    	        while (currentValue < targetValue) {
    	    	            actions.clickAndHold(slider).moveByOffset(step, 0).release().perform();
    	    	            Thread.sleep(200); // Allow some time for the value to update

    	    	            String currentValueStr = textBox.getAttribute("value");
    	    	            currentValue = Integer.parseInt(currentValueStr);

    	    	            if (currentValue >= targetValue) {
    	    	                break;
    	    	            }
    	    	        }

    	    	        // Verify the slider value
    	    	        String sliderValue = textBox.getAttribute("value");
    	    	        System.out.println("Slider moved to: " + sliderValue);

    	    	        // Step 5: Update the Text Field to 560
    	    	        textBox.click();
    	    	        textBox.clear();
    	    	        textBox.sendKeys("560");
    	    	        //textBox.sendKeys(Keys.ENTER);  // Ensure the value is submitted
    	    	        Thread.sleep(500); // Allow some time for the slider to update

    	    	        // Step 6: Validate Slider Value for 560
    	    	        sliderValue = textBox.getAttribute("value");
    	    	        System.out.println("Text field set to: " + sliderValue);
    	    	        assert sliderValue.equals("560") : "Slider value is not 560";

    	    	        // Step 7: Select CPT Codes
    	    	        actions.moveToElement(driver.findElement(By.xpath("//h2[text()='CPT Codes']"))).perform();
    	    	        driver.findElement(By.id("CPT-99091")).click();  // Adjust the locator based on actual checkbox id
    	    	        driver.findElement(By.id("CPT-99453")).click();  // Adjust the locator based on actual checkbox id
    	    	        driver.findElement(By.id("CPT-99454")).click();  // Adjust the locator based on actual checkbox id
    	    	        driver.findElement(By.id("CPT-99474")).click();  // Adjust the locator based on actual checkbox id

    	    	     
    	    	


    	    
    	

       
    }
}
