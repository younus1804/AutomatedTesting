import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginTest {

	private static WebDriver driver;
    private static String URL = "http://thedemosite.co.uk/";
    private static ExtentReports extent;
	private static ExtentTest test;
	

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.setHeadless(true);
        driver = new ChromeDriver(cOptions);
        cOptions.setExperimentalOption("profile.default_content_setting_values.cookies", 2); 
    	cOptions.setExperimentalOption("network.cookie.cookieBehavior", 2); 
    	cOptions.setExperimentalOption("profile.block_third_party_cookies", true);
        driver.manage().window().setSize(new Dimension(1366, 768));
    }
    
    @Before
 	public void setup() {

 		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 		try {
 			driver.get(URL);
 		} catch (TimeoutException e) {
 			System.out.println("Page: " + URL + " did not load within 30 seconds!");
 		}

 	}
    
    @Test
   	public void addAUserTest() throws Exception {
    	
    	driver.get(URL + "/addauser.php");
    	WebElement input = driver.findElement(By.name("username"));
    	input.sendKeys("guest");
		input.submit();
    	WebElement input1 = driver.findElement(By.name("password"));
		input1.sendKeys("guest");
		input1.submit();
    }
    
    @AfterClass
  	public static void tearDown() {
  		driver.quit();
  	}
}
