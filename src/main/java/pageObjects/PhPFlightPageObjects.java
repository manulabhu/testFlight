package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhPFlightPageObjects {
	public WebDriver driver;
	
	public PhPFlightPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	//Defining objects variable to private and methods to public is encapsulation aspect of class so we are hiding web element data to this class only and methods to public so other class can still use it on LandingPage
	
	private @FindBy(xpath="//div[@class='menu-horizontal-wrapper-02']/nav/ul/li[2]/a")
	WebElement getFlight;
	
	private @FindBy(xpath="//label[@for='flightSearchRadio-2']")
	WebElement onewayRadio;
	
	private @FindBy(xpath="//label[@for='flightSearchRadio-1']")
	WebElement rndtrpRadio;
	
	private @FindBy(xpath="//div[@id='s2id_location_from']/a")
	WebElement fromRoute;
	
	private @FindBy(id="s2id_location_to")
	WebElement toRoute;
	
	
	

	
	
	
	
	
	
	
	
	public WebElement selectFlightBtn()
	{
		return getFlight;
	}
	
	public WebElement selectonewayButton()
	{
		return onewayRadio;
	}
	
	public WebElement selectrndtrpButton()
	{
		return rndtrpRadio;
	}
	
	
	public WebElement autosuggestFrom()
	{
		return fromRoute;
	}
	
	public WebElement autosuggestTo()
	{
		return toRoute;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
