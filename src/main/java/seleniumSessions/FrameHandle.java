package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/");
		Thread.sleep(3000);
		
		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
		List<WebElement> frameList= driver.findElements(By.tagName("frame"));
		System.out.println(frameList.size());
		driver.switchTo().frame(driver.findElement(By.name("main")));

		String headerText = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(headerText);
		
		String expText = "Title bar (top.html)";
		
		if(headerText.equalsIgnoreCase(expText))
		{
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Test fail!");
		}
		
		driver.switchTo().defaultContent(); //come back to the main page
		//driver.switchTo().parentFrame(); //come back to the main or parent frame
		
		String mainFrameText =  driver.findElement(By.xpath("(//frame[@name='void1'])")).getText();
		System.out.println(mainFrameText);
		//driver.close();
		
		
		//frames are used for security point of view
	}

}
