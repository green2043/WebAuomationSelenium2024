package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		//type='File'
		WebElement uploadFileBtnElement  = driver.findElement(By.id("file-upload"));
		//you don't need to click the element, selenium automatically handle internally, you just need to give file with the path
		//selenium webdriver can't access windows UI
		uploadFileBtnElement.sendKeys("C:\\Users\\satya\\OneDrive\\Pictures\\wallpapersden.com_demon-slayer-art_3000x1364.jpg");
	}

}
