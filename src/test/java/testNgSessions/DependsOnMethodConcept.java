package testNgSessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	
	/*
	 AAA stands for: Arrange, Act, Assert.:
This is a commonly taught structure for unit tests. This structure guides us in how to "arrange" our tests, 
and is generally considered to produce tests that are easier to maintain.

Each test should start with an arrange section, then the act section, 
and finally the assert section. Sections don't generally overlap (with few exceptions).
*/
	
	/*
	 Test cases should be independent of each other, meaning they should not rely on the outcomes of previous test cases
	 Best example: CRUD operation
	 */
	
	//CRUD
	//create a user+Assert -T1
	//Get a user + Assert - T2
	// In this case T2 is dependent on T1 - If T1 failed then T2 can't be performed -- not recommended
	//-------------------------- -------------------------------------------------------------------
	//CRUD
	//create a user+Assert -T1
	//create a user , Get a user , Assert -T2
	//create a user , Get a user , Update the same user with, Assert -T3
	//create a user , Get a user , Delete the same user with, Assert -T4
	// All TC independent of each other- RECOMMENDED
	//-------------------------------------------------------------------------------------------
	
	//AAA- Arrange, Act, Assert
	//test cases should be/ must be independent
	//it should not maintain any order
	//can be executed in any order
	
	//Assert: Only one assertion should be there in a test case
	//We can avoid giving priority  as well for the TCs

	@Test
	public void searchTest()
	{
		System.out.println("search Test");
		int a=9/3;
	}
	
	@Test (dependsOnMethods = "searchTest")
	public void addToCartTest()
	{
		System.out.println("add To Cart Test");
		int b=9/0;
	}
	
	@Test (dependsOnMethods = "addToCartTest")
	public void payementTest()
	{
		System.out.println("payement Test");
	}

}
