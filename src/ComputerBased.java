import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class ComputerBased {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://computer-database.gatling.io/computers");
		
		driver.findElement(By.cssSelector("a.btn.success")).click();
		driver.findElement(By.id("name")).sendKeys("Hello Guhananthan");
		driver.findElement(By.id("introduced")).sendKeys("1991-10-31");
		driver.findElement(By.id("discontinued")).sendKeys("1995-10-31");
		
		WebElement compDriv = driver.findElement(By.id("company"));
		Select company = new Select(compDriv);
		company.selectByVisibleText("Thinking Machines");
		
		driver.findElement(By.cssSelector(".btn.primary")).click();
		
		String value = driver.findElement(By.cssSelector(".alert-message.warning"))
				.getText().split("Computer")[1].trim().split("has")[0].trim();
		System.out.println(value);
		
		if(value.contains("Guhananthan")) {
			Assert.assertTrue(true);
		}
		
	}    
}
