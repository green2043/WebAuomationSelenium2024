package testNgSessions;

import org.testng.annotations.Test;

public class PriorityTest {
	
	// If some @Test doesn't have priority, and some has priority , in that case it will pick the non-priority one first
	//Priority value can be -ve
	//default priority = alphabetical order
	
	@Test//(priority = 3)
	public void aTest()
	{
		System.out.println("aTest");
	}
	
	@Test //(priority = 2)
	public void bTest()
	{
		System.out.println("bTest");
	}
	
	@Test //(priority = -1)
	public void cTest()
	{
		System.out.println("cTest");
	}
	
	@Test (priority = 1)
	public void dTest()
	{
		System.out.println("dTest");
	}
	
	@Test (priority = 2)
	public void eTest()
	{
		System.out.println("eTest");
	}
	
	
	

}
