package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> imageList=	driver.findElements(By.tagName("img"));
		
		System.out.println("total images:"+" "+imageList.size());
		
		//print src, altitude, height of each image
		for(WebElement e: imageList)
		{
			String srcValue = e.getAttribute("src");
			String altValue = e.getAttribute("alt");
			String heightValue = e.getAttribute("height");
			
			System.out.println(srcValue+"| |"+altValue+"| |"+heightValue);
		}
		
		

	}

}
