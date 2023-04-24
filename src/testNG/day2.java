package testNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	
	@Test(groups= {"smoke"})
	public void ploan() {
		System.out.println("Ploan in class day2");
	}

	@BeforeTest
	public void prequisites() {
		System.out.println("I will execute first from Day 2 ");
	}
}
