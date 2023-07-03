import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SellIntroduction{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//System.setProperty("webdriver.chrome.driver","/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");
		//WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","/Users/guhananthansivakumar/Projects/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
