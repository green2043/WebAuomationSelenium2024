package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementtoBeClicked {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/events/greatindianfestival?linkCode=ll2%2Cur2&linkId=6e8e3d8f31513cf92e862073d65fefae%2C41c3b8fb1ad95d37bf6d1ce4f06d8dc1&_encoding=UTF8&ref_=as_li_ss_tl&language=en_IN&tag=irctcdev07-21%2Circtcdev07-21&creative=24630&camp=3638");
//		By locator= By.xpath("//a[text()='Amazon Global Selling']");
//		
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

		// clickElementWhenReady(By.xpath("//a[text()='Amazon Global Selling']"),10);

		// clickElementWhenReady(By.xpath("//a[text()='Amazon Global Selling111']"),10);
		// TimeoutException:-(tried for 10 second(s) with 500 millisecond interval):default polling time is 500ms,i.e-0.5sec

		clickElementWhenReady(By.xpath("//a[text()='Amazon Global Selling111']"), 10, 1);
		// TimeoutException:-(tried for 10 second(s) with 500 milliseconds interval):default polling time is 1000ms,i.e-1sec
		// we can customize the polling time

	}

	public static void clickElementWhenReady(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

	}

}
