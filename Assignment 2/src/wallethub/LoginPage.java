package wallethub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By banner_login_button = By.className("login");
	By username =By.name("em");
	By password=By.name("pw");
	By login_button=By.xpath("//div[@class='btns']");
	By review = By.xpath("//a[@href='/profile/test-insurance-company-13732055i#reviews']");
	By rating = By.xpath("//review-star[@class='rvs-svg']/div/*[name()='svg' and @class='rvs-star-svg'][4]");
	By choice = By.xpath("//div[@class='dropdown second opened']/ul/li[2]");
	By drop_down = By.xpath("//div[@class='dropdown second']");
	By review_text = By.xpath("//div[@class='android']/textarea");
	By submit = By.xpath("//div[@class='sub-nav-ct']/div[2]");
	By continue_button = By.xpath("//div[@class='btn rvc-continue-btn']");
	By review_content = By.xpath("//div[@data-pos='0']");
	
	public WebElement Userid()
	   {
		   return driver.findElement(username);
	   }
	         
    public WebElement Password()
	   {
		   return driver.findElement(password);
	   }
	   
	public WebElement Login()
	   {
		   return driver.findElement(login_button);
	   }
	
	public WebElement Review()
	{
		return driver.findElement(review);
	}
	
	public WebElement Rating()
	{
		return driver.findElement(rating);
	}
	
	public WebElement Login_Button()
	{
		return driver.findElement(banner_login_button);
	}
	
	public WebElement Choice()
	{
		return driver.findElement(choice);
	}
	
	public WebElement Dropdown()
	{
		return driver.findElement(drop_down);
	}
	
	public WebElement Review_Text()
	{
		return driver.findElement(review_text);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}
	
	public WebElement Continue()
	{
		return driver.findElement(continue_button);
	}
	
	public WebElement Verify_Review()
	{
		return driver.findElement(review_content);
	}
	
}
