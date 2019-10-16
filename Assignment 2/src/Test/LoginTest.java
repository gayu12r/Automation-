package Test;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseConfiguration.Excel;
import wallethub.LoginPage;

public class LoginTest {
 
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/gayathri/Documents/Installers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://wallethub.com");
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		Object[][] data = Excel.getTestData("login");
		return data;
	}
	
	@Test(dataProvider = "getLoginData")
	public void Login(String username, String password, String review) throws InterruptedException
	{
		LoginPage obj=new LoginPage(driver);
		Actions actions = new Actions(driver);
		obj.Login_Button().click();
		obj.Userid().sendKeys(username);
		obj.Password().sendKeys(password);
		obj.Login().click();
		Thread.sleep(2000);
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		obj.Review().click();
		Thread.sleep(2000);
		actions.moveToElement(obj.Rating()).perform();
		Thread.sleep(5000);
		obj.Rating().click();
		obj.Dropdown().click();
		obj.Choice().click();
		Thread.sleep(5000);
		obj.Review_Text().click();
		obj.Review_Text().sendKeys(review);
		Thread.sleep(5000);
		obj.Submit().click();
		Thread.sleep(5000);
		obj.Continue().click();
		String rev_text = obj.Verify_Review().getText();
		System.out.println(rev_text);
		try {
			 assertTrue(rev_text.equals(review));
		    } 
		catch (AssertionError e) {
		     System.out.println("Sorry the values are not equal");
		     throw e;
		    }
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
