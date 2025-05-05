package seleniumSessions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDomElement {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Navigate to the URL
        driver.get("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(4000);
        
//        driver.findElement(By.id("pizza")).sendKeys("Veg Pizza"); --> NoSuchElementException, because it's under shadowdom element
//			shadowdom is an special html dom
// 			selenium directly won't support shadowdom
//        	if shadow-root(closed) , then it can't be automated, neither by selenium,cypress nor playwright
        
// This is JS code using CSS selector:  document.querySelector("#userName").shadowRoot.querySelector("#app2").shadowRoot.querySelector("#pizza")
        // after inspect run this JS code in console 
        
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the shadow host to be present
        //WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userName")));
       
        JavascriptExecutor js = (JavascriptExecutor)driver;  // hold ctrl, click on JavascriptExecutor:- it will navigate to JavascriptExecutor interface
        //then hold ctrl and click on executeScript>Then select implementation>It' implemented by remote web driver> executeScript method
        /*
         @Override
  	public Object executeScript(String script, Object... args) {
    List<Object> convertedArgs =
        Stream.of(args).map(new WebElementToJsonConverter()).collect(Collectors.toList());

    return execute(DriverCommand.EXECUTE_SCRIPT(script, convertedArgs)).getValue();
  } 
         */
        
        //right click>copy JS path>paste in console>hit enter
        
        WebElement pizza = (WebElement) js.executeScript(
        	    "return document.querySelector('#userName').shadowRoot.querySelector('#app2').shadowRoot.querySelector('#pizza')");
        pizza.sendKeys("One margherita pizza"); // ---->> Getting exception
        
       
		/*
		 * WebElement shadowRootObj = (WebElement)
		 * js.executeScript("return arguments[0].shadowRoot", shadowHost);
		 * 
		 * if (shadowRootObj != null) { // Wait for the element within the shadow DOM to
		 * be present WebElement pizza =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#kils"
		 * )));
		 * 
		 * // Send keys to the element pizza.sendKeys("One margherita pizza"); } else {
		 * System.out.
		 * println("Shadow root is null. Unable to access the element within the shadow DOM."
		 * ); }
		 */
        
        //Shadow DOM elements are very rare, very slow to reach

	}

}
