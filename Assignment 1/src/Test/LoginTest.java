package Test;

import FaceBook.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseConfiguration.Excel;

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
		driver.get("https://www.facebook.com");
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		Object[][] data = Excel.getTestData("login");
		return data;
	}
	
	@Test(dataProvider = "getLoginData")
	public void Login(String username, String password, String post) throws InterruptedException
	{
		System.out.println(driver);
		LoginPage obj=new LoginPage(driver);
		obj.Userid().sendKeys(username);
		obj.Password().sendKeys(password);
		obj.Login().click();
		Thread.sleep(5000);
		obj.Post().click();
		obj.Write_Post().sendKeys(post);
		obj.Submit_Post().click();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
