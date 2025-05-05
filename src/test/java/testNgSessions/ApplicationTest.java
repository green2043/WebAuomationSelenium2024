package testNgSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApplicationTest {

	//global Preconditions - BeforeSuite, BeforeTest, BeforeMethod
	//precondition - Before
	//test steps - Test
	//validation : actual vs expected -------> Assertion using TestNG -- Assert
	//post step -- After
	
	
	
    /**
     Before suite --- connect with DB
	Before Test --- Create user
	Before Class --- Launch Browser
     
     Before Method --- Login
	CarTest
	After method-- LogOut
	
	Before Method --- Login
	HomePageTest
	After method-- LogOut
	
	Before Method --- Login
	SearchTest
	After method-- LogOut
	
	
	After class-- CloseBrowser
	After Test-- DeleteUser
	
	After suite-- DisconnectDB
	
     	
     */
	
	//1
	@BeforeSuite
	public void ConncetWithDB()
	{
		System.out.println("Before suite --- connect with DB");
	}
	
	//2
	@BeforeTest
	public void CreateUser()
	{
		System.out.println("Before Test --- Create user");
	}
	
	//3
	@BeforeClass
	public void LaunchBrowser()
	{
		System.out.println("Before Class --- Launch Browser");
	}
	
	//4 7 10
	@BeforeMethod
	public void Login()
	{
		System.out.println("Before Method --- Login");
	}
	
	
	
	//8
	@Test
	public void HomePageTest()
	{
		System.out.println("HomePageTest");
	}
	
	
	//11
	@Test
	public void SearchTest()
	{
		System.out.println("SearchTest");
	}
	
	//5
	@Test
	public void CarTest()
	{
		System.out.println("CarTest");
	}
	
	
	//6 9 12
	@AfterMethod
	public void LogOut()
	{
		System.out.println("After method-- LogOut");
	}
	
	//13
	@AfterClass
	public void CloseBrowser()
	{
		System.out.println("After class-- CloseBrowser");
	}
	
	//14
	@AfterTest
	public void DeleteUser()
	{
		System.out.println("After Test-- DeleteUser");
	}
	
	//15
	@AfterSuite
	public void DisconnectDB()
	{
		System.out.println("After suite-- DisconnectDB");
	}
}
