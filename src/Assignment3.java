import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");*/
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String userName = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[1]")).getText();
		String password = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText();
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("label[class='customradio']:nth-child(2)")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement drop = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select drpDwn = new Select(drop);
		drpDwn.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
		List <WebElement> prdcts = driver.findElements(By.cssSelector(".card-footer .btn-info"));

		for(int i =0;i<prdcts.size();i++)
		{
		prdcts.get(i).click();
		}
		driver.findElement(By.partialLinkText("Checkout")).click();
		
		driver.quit();
	}

}
