package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendeHandeling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
//		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
//		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.id("datepicker")).click();
		//selectDate("23");
//		selectCalenderDate("14");
		
//		String actMonthYear= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		System.out.println(actMonthYear);
//		
//		while(!actMonthYear.equalsIgnoreCase("march 2025"))
//		{
//			//click on next icon
//			driver.findElement(By.xpath("//span[text()='Next']")).click();
//			Thread.sleep(1000);
//			actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//			System.out.println(actMonthYear);
//			
//		}
//		selectDate("25");
		
		selectFutureDate("May 2025", "31");
		
	}
	
	public static void selectFutureDate(String expmonthYear, String day) throws InterruptedException 
	{
		
		if(expmonthYear.contains("February") && Integer.parseInt(day)>29)
		{
			System.out.println("wrong day/date passd...please pass the right day/date for FEB month"+day);
			return;
		}
		
		if(Integer.parseInt(day)>31)
		{
			System.out.println("wrong day/date passd...please pass the right day/date"+day);
			return;
		}
		
		String actMonthYear= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(actMonthYear);
		
		while(!actMonthYear.equalsIgnoreCase(expmonthYear))
		{
			//click on next icon
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(1000);
			actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(actMonthYear);
			
		}
		selectDate(day);
	}
	
	
	
	public static void selectPastDate(String expmonthYear, String day) throws InterruptedException 
	{
		
		if(expmonthYear.contains("February") && Integer.parseInt(day)>29)
		{
			System.out.println("wrong day/date passd...please pass the right day/date for FEB month"+day);
			return;
		}
		
		if(Integer.parseInt(day)>31)
		{
			System.out.println("wrong day/date passd...please pass the right day/date"+day);
			return;
		}
		
		String actMonthYear= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(actMonthYear);
		
		while(!actMonthYear.equalsIgnoreCase(expmonthYear))
		{
			//click on next icon
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			Thread.sleep(1000);
			actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println(actMonthYear);
			
		}
		selectDate(day);
	}
	
	
	
	
	public static void selectCalenderDate(String day) 
	{
		List<WebElement> dayList=driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
		System.out.println(dayList.size());
		
		for(WebElement e: dayList)
		{
			String text= e.getText();
			if (text.equals(day)) 
			{
				e.click();
				break;
			} 
		}
		
	}
	
	public static void selectDate(String date) 
	{
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
	}
	
	
	//div.DayPicker-Months div.DayPicker-Day--disabled:not(.DayPicker-Day--outside)
	//'not' keyword :- ignore which elements are disabled
	
	//div.DayPicker-Day--selected :-today's date
	
	//div.DayPicker-Day:not(.DayPicker-Day--outside):not(.DayPicker-Day--disabled) :- only enable dates from both the months

}
