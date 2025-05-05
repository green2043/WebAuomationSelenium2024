package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDownConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By choices = By.xpath("//span[@class='comboTreeItemTitle']");

		Thread.sleep(2000);
		// 1. Single selection
		// selectChoice(choices, "choice 1");

		// 2. Multiple selection
		// selectChoice(choices, "choice 1", "choice 2", "choice 2 3", "choice 7");

		// 3. all selection:
		// selectChoice(choices,"all" );

		// 4.no choice available
		selectChoice(choices, "choice 9");

	}
	
	/**
	 * This method is handling single, multiple and all choices selection
	 * This method is also handling if choice is not available
	 * Please pass the choices which are present in case of multiple choice selection 
	 * @param locator
	 * @param choice
	 */
	public static void selectChoice(By locator, String... choice) // String... choice = String choice []---both are
																	// same array
	{
		List<WebElement> choicesList = driver.findElements(locator);
		boolean flag = false;
		
		if (!choice[0].equalsIgnoreCase("all")) 
		{
			for (WebElement e : choicesList) {
				String text = e.getText();
				// System.out.println(text);
				for (int i = 0; i < choice.length; i++) {
					if (text.equals(choice[i])) {
						flag = true;
						e.click();
						break;
					}
				}

			}
		}
		else {
			//all selection logic
			try {
				for(WebElement e:choicesList) //0-44--->14 are interactable
				{
				e.click();
				flag = true;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				
				//ElementNotInteractable Exception
			}
		}
				
			if (flag==false) {
				
				System.out.println("choice is not availale..."+choice[0]);
			}
		

		
	}

}
