import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.*;

public class ActionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * System.setProperty("webdriver.chrome.driver",
		 * "/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");
		 * WebDriver driver = new ChromeDriver(options);
		 */

		System.setProperty("webdriver.gecko.driver", "/Users/guhananthansivakumar/Projects/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();

		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build()
				.perform();

	}

}
