package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
}
	
// Define objects in Login page
	
	private @FindBy(xpath = "//input[@id='user_email']")
	WebElement getEmail;
	
	private @FindBy(xpath = "//input[@id='user_password']")
	WebElement getPassword;
	
	private @FindBy(xpath = "//input[@name='commit']")
	WebElement getLogin;
	
	
	// Define Methods of created object in login page
	
	public WebElement enterEmail()
	{
		System.out.println("Email id is provided");
		return getEmail;
	}
	
	public WebElement enterPassword()
	{
		System.out.println("Password is provided");
		return getPassword;
	}
	
	public WebElement clickLogin()
	{
		System.out.println("Login button is clicked");
		return getLogin;
	}
}
