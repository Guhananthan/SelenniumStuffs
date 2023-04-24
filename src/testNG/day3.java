package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@BeforeMethod
	public void beforeEveryMethod() {
		System.out.println("I will execute before every method from class Day3");
	}
	
	@AfterMethod
	public void afterEveryMethod() {
		System.out.println("I will execute after every method from class Day3");
	}
	
	@Test
	public void webLoginCarLoan() {
		System.out.println("Hello webLoginCarLoan from day3 class");
	}
	
	@Test
	public void mobileLoginCarLoan() {
		System.out.println("Hello mobileLoginCarLoan from day3 class");
	}
	
	@Test
	public void mobileSignINCarLoan() {
		System.out.println("Hello mobileSignINCarLoan from day3 class");
	}
	
	@Test
	public void mobileSignOutCarLoan() {
		System.out.println("Hello mobileSignOutCarLoan from day3 class");
	}
	
	
	@Parameters({"URL"})
	@Test(groups= {"smoke"})
	public void APILoginCarLoan(String URLname) {
		System.out.println("Hello APILoginCarLoan from day3 class");
		System.out.println(URLname);
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("I will execute after the complete Framework @ LAST");
	}
}
