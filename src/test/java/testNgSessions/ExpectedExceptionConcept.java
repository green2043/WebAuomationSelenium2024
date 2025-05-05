package testNgSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name;
	
	
	@Test(expectedExceptions = ArithmeticException.class)  //Test Pass!
	public void calTest()
	{
		System.out.println("calTest");
		int a =9/0;
	}

	
	@Test(expectedExceptions = ArithmeticException.class)  //Test Fail!
	
	public void misMatchExceptionTest()
	{
		System.out.println("calTest");
		//int a =9/0;
		
		ExpectedExceptionConcept obj = null;
		obj.name="Tom";
	} //Expected exception of type class java.lang.ArithmeticException but got java.lang.NullPointerException: Cannot assign field "name" 	because "obj" is null
	
	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})  //Test Pass!
	public void multipleException()
	{
		System.out.println("calTest");
		int a =9/0;
		
		ExpectedExceptionConcept obj = null;
		obj.name="Tom";
	}
	
	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class},priority = 1,description = "exception test")  //Test Pass!
	public void multipleExceptionWithPrio()
	{
		System.out.println("calTest");
		int a =9/0;
		
		ExpectedExceptionConcept obj = null;
		obj.name="Tom";
	}


	
	
	
}
