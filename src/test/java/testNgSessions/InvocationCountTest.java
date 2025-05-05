package testNgSessions;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount = 10) // using this one @Test TC can execute 10 times
	public void searchTest()
	{
		System.out.println("searchTest");
		
		/* OUTPUT:
searchTest
searchTest
searchTest
searchTest
searchTest
searchTest
searchTest
searchTest
searchTest
searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
PASSED: testNgSessions.InvocationCountTest.searchTest
*/
	}
	

}
