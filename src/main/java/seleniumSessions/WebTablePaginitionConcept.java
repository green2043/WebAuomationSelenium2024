package seleniumSessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablePaginitionConcept {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navigate to the URL
		// driver.get("https://selectorshub.com/xpath-practice-page/");
		//driver.get("https://editor.datatables.net/examples/api/checkbox.html");
		driver.get("https://www.gyrocode.com/projects/jquery-datatables-checkboxes/");
		

		while (true) {
			if (driver.findElements(By.xpath("//td[text()='Software Engineer']")).size() > 0) {
				selectMultipleItems("Software Engineer");
				
			}  
			
	            // Pagination logic
	            WebElement next = driver.findElement(By.xpath("//div[@id='example_paginate']//a[@id='example_next']"));
	            if (next.getAttribute("class").contains("disabled")) {
	                System.out.println("Pagination is over...");
	                break;
	            }			
				next.click();
				Thread.sleep(1000);
			}						
		
		
		/*
		 * while (true) {
		 * if(driver.findElements(By.xpath("//td[text()='Glendora']")).size()>0) {
		 * selectItem("Glendora") ; break; } else { //pagination logic WebElement next =
		 * driver.findElement(By.xpath("//button[@aria-label='Next']")); next.click();
		 * Thread.sleep(5000); } }
		 */

	}

	public static void selectItem(String text) {
		 try {
	        driver.findElement(By.xpath("//td[text()='" + text + "']/following-sibling::td//input[@type='checkbox']")).click();
	    } catch (NoSuchElementException e) {
	        driver.findElement(By.xpath("//td[text()='" + text + "']/preceding-sibling::td//input[@type='checkbox']")).click();
	    }
	}
	public static void selectMultipleItems(String position) {
		List<WebElement> checkboxList =driver.findElements(By.xpath("(//td[text()='"+position+"'])/preceding-sibling::td/input[@type='checkbox']"));	
		for(WebElement e:checkboxList )
		{
			e.click();
		}
				
	}

}
