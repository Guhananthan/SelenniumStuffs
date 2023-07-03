import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
public class BrokenUrls {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");*/
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		
		
		for(WebElement link :links) {
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode<400, "the link with text " +link.getText()+ " is broken with code "+responseCode);
			/*if(responseCode>400) {
				System.out.println("the link with text " +link.getText()+ " is broken with code "+responseCode);
				Assert.assertTrue(false);
			}*/
			
			
		}
		
		a.assertAll();
		
		
	}

}
