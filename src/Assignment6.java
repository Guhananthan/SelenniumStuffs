import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"/Users/guhananthansivakumar/Projects/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	    driver.findElement(By.id("checkBoxOption2")).click();
	    String option2 = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
	    
	    WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));

        Select s=new Select(dropdown);
	    
        s.selectByVisibleText(option2);

        driver.findElement(By.name("enter-name")).sendKeys(option2);

        driver.findElement(By.id("alertbtn")).click();
	    
        String text=  driver.switchTo().alert().getText();

        if(text.contains(option2))

        {

       System.out.println("Alert message success");
       driver.switchTo().alert().accept();

        }

        else

       System.out.println("Alert msg failed");
	    
	    
	    
	    
	    
	}

}
