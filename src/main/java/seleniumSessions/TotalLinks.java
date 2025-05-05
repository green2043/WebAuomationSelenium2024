package seleniumSessions;

import java.awt.print.Printable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	public static void main(String[] args) {
		//1. capture total links
		//2. print the text of each link
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//html tag: <a>
		List<WebElement> linkList= driver.findElements(By.tagName("a"));
		System.out.println("total links:"+"  "+linkList.size());
		
//		for(int i=0; i<linkList.size(); i++)
//		{
//			String text= linkList.get(i).getText();
//			//System.out.println(i+"="+text);
//			//System.out.println(text);
//			if (!(text.length()==0)) 
//			{
//				System.out.println(i+"="+text);
//				
//			}
//		}
		
		//for each:
		int count=1;
		for(WebElement e : linkList)
		{
			String text =e.getText();
			if (!(text.length()==0)) 
				{
					System.out.println(count+"="+text);
					
				}
			count++;
			
		}
	}
	

}
