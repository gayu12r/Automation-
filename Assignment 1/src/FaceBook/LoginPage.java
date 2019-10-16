package FaceBook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	By username =By.id("email");
	By password=By.name("pass");
	By login=By.xpath("//input[@value='Log In']");
	By write_post = By.xpath("//div[@data-testid='status-attachment-mentions-input']");
	By post = By.xpath("//div[@aria-label='Create a post']");
	By submit_post = By.xpath("//button[@data-testid='react-composer-post-button']");
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
		   return driver.findElement(login);
	   }
	
	public WebElement Post()
	{
		return driver.findElement(post);
	}
	
	public WebElement Write_Post()
	{
		return driver.findElement(write_post);
	}
	
	public WebElement Submit_Post()
	{
		return driver.findElement(submit_post);
	}
}
