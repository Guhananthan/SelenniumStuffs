package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day1 {

	
	@AfterTest
	public void lastExceution() {
		System.out.println("I will execute LAST from day1");
	}
	
	@Test
	public void Demo() {
		System.out.println("hello Demo in Day1 Class");
	}
	
	@Test
	public void secondTest() {
		System.out.println("hello second Test in Day1 Class");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I will execute FIRST");
	}
	
	
}
