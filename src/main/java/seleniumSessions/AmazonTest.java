package seleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
	
		String browserName="Chrome";
		
		BrowserUtil browserUtil = new BrowserUtil();
		
		browserUtil.lunchBrowser(browserName);
		
		
		//browserUtil.launchUrl(null); //NOK
		//browserUtil.launchUrl("www.amazon.com"); //NOK
		//browserUtil.launchUrl("http://www.amazon.com"); //no http for amazon
		browserUtil.launchUrl("https://www.amazon.com");
		String actPageTitle= browserUtil.getPageTitle();
		
		//validation point
		if (actPageTitle.contains("Amazon")) 
		{
			System.out.println("correct title");
		} 
		else 
		{
			System.out.println("incorrect title");
		}
		
		
		browserUtil.driver.quit();

	}

}
