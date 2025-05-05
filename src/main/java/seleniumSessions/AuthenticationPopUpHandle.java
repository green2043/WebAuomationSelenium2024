package seleniumSessions;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		
		//after launching getting a pop-up, this is not  a JS pop-up
		//uid = admin, pwd=admin, see how I added in the url
		
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//		
//		after @ the domain name = 'the-internet.herokuapp.com'
//		even if you provide the wrong credentials then it will accept the pop-up by default
//		limitation is if password contains @ then it will understand something else, and won't work
//		make sure password shouldn't contain any @
		
		if(doLoginForAuthPopUp("admin","admin","the-internet.herokuapp.com/basic_auth"))
		{
			System.out.println("logged in successfully");
		}
		

	}
	
	public static boolean doLoginForAuthPopUp(String username, String password,String url)
	{
		driver.get("https://" + username + ":" + password + "@" + url);
		String message = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		if(message.contains("Congratulations!"))
		{
			return true;
		}
		return false;
	}

}