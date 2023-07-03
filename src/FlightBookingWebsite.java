import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightBookingWebsite {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");*/
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Handling Static DropDown
		WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDownList = new Select(dropDown);
		dropDownList.selectByIndex(3);
		System.out.println(dropDownList.getFirstSelectedOption().getText());
		dropDownList.selectByVisibleText("AED");
		System.out.println(dropDownList.getFirstSelectedOption().getText());
		dropDownList.selectByValue("INR");
		System.out.println(dropDownList.getFirstSelectedOption().getText());

		// Handing the Passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		/* Handling Dynamic DropDown */

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		/* Handling Calender UI */
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		/* Handling AutoSuggestive DropDown */

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> optionns = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : optionns) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		/* Handling Assertions */
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); // handling passengers

		/* Handling Checkboxes and finding the count of Checkboxes */

		System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());

		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

		/* handling roundtrip radiobutton */

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
