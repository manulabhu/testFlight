package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {

	public WebDriver driver;
	
	public LandingPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Defining objects variable to private and methods to public is encapsulation aspect of class so we are hiding web element data to this class only and methods to public so other class can still use it on LandingPage
	
	private @FindBy(xpath="/html/body/header/div[1]/div/nav/ul/li[4]/a/span")
	WebElement getLogin;
	
	private @FindBy(xpath="//li[@class='active']/a[1]")
	WebElement getHome;
	
	private @FindBy(xpath="//li[5]/a[1]")
	WebElement getPractice;
	
	private @FindBy(xpath="//div[@class='text-center']/h2[1]")
	WebElement getTitle;
	
	private @FindBy(xpath="//li[@class='active']/a[1]")
	WebElement homeButton;
	

	
	//Define Methods to public
	

	public WebElement logIn()
	{
		System.out.println("Login link is clicked");
		return getLogin;
	}
	
	
	public WebElement Home()
	{
		System.out.println("");
		return getHome;
	}
	
	public WebElement Practice()
	{
		System.out.println("Practice button is clicked");
		return getPractice;
	}
	
	public WebElement getTitle()
	{
		System.out.println("");
		return getTitle;
	}
	
	
	
	public WebElement getHomeButton()
	{
		System.out.println("");
		return homeButton;
	}
	
	
	
}
