package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JoinRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

public class FEsGenericMethods {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		By footerLinksBy = By.xpath("//div[contains(@class,'navFooterLinkCol')]//a");

		int actFooterCount = totalElementsCount(footerLinksBy);
		System.out.println(actFooterCount);
		if (actFooterCount == 22) {

			System.out.println("footer count -- PASS");

		} else {
			System.out.println("footer count -- FAIL");
		}

		List<String> actualElementtextList = getElementsTextList(footerLinksBy);
		System.out.println(actualElementtextList);

		if (actualElementtextList.contains("Help")) {
			System.out.println("Pass");
		}
		if (actualElementtextList.contains("Sell under Amazon Accelerator")) {
			System.out.println("Pass");
		}
		if (actualElementtextList.contains("Sell under Amazon Accelerator")) {
			System.out.println("Pass");
		}
		if (actualElementtextList.contains("About us")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public static int totalElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<String> getElementsTextList(By locator) {
		List<WebElement> elementList = getElements(locator);
		List<String> elementTextList = new ArrayList<String>();

		for (WebElement e : elementList) {
			String text = e.getText();
			elementTextList.add(text);
		}
		return elementTextList;

	}

}
