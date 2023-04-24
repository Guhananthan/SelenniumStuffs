package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Executing all methods in CLASSSSS");
	}
	
	@Parameters({"URL"})
	@Test
	public void webLoginHomeLoan(String urlName) {
		System.out.println("Hello webLoginHomeLoan from day4 class");
		System.out.println(urlName);
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Executing all methods in CLASSSSS");
	}
	
	@Test(groups= {"smoke"})
	public void mobileLoginHomeLoan() {
		System.out.println("Hello mobileLoginHomeLoan from day4 class");
	}
	
	@Test(dependsOnMethods= {"webLoginHomeLoan","mobileSignOutHomeLoan"})
	public void mobileSignInHomeLoan() {
		System.out.println("Hello mobileSignInHomeLoan from day4 class");
	}
	@Test
	public void mobileSignOutHomeLoan() {
		System.out.println("Hello mobileSignOutHomeLoan from day4 class");
	}
	@Test
	public void APILoginHomeLoan() {
		System.out.println("Hello APILoginHomeLoan from day4 class");
	}
}
