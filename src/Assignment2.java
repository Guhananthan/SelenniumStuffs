import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");*/
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Sadhana");
		driver.findElement(By.name("email")).sendKeys("sadhu@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("sfadf");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropDown = new Select(gender);
		dropDown.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10/12/2023");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(
				driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.quit();

	}

}
