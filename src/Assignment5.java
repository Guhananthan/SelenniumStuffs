import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.id("content")).getText());

	}

}
