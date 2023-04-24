import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.JavascriptExecutor;
public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.path2usa.com/travel-companion/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		/*Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.name("form_fields[travel_comp_date]"))).click().build().perform();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();", driver.findElement(By.name("form_fields[travel_comp_date]")));*/
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,1100)");
		
		Thread.sleep(3000);
		WebElement Date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
		Date.click();
		
		
		/* Setting up the month in calendar */

		while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("January")) {

			driver.findElement(
					By.cssSelector("[class='flatpickr-calendar animate arrowTop open'] [class='flatpickr-next-month']"))
					.click();
			Thread.sleep(2000);
		}

		/* setting up the date in calendar */
		
		int count = driver.findElements(By.cssSelector(".flatpickr-day ")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).getText();
			if (text.equalsIgnoreCase("24")) {
				driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).click();
				break;
			}
		}
		String date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value");

		System.out.println("The select date is:"+date);

	}

}
