package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPageObjects {
	
	public WebDriver driver;
	
	public FlightPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Defining objects variable to private and methods to public is encapsulation aspect of class so we are hiding web element data to this class only and methods to public so other class can still use it on LandingPage
	
	private @FindBy(xpath="//div[@id='divpaxinfo']")
	WebElement getPassengers;

	private @FindBy(id="hrefIncAdt")
	WebElement plusAdult;
	
	private @FindBy(id="hrefIncChd")
	WebElement plusChild;
	
	private @FindBy(id="hrefDecChd")
	WebElement minusChild;
	
	private @FindBy(id="btnclosepaxoption")
	WebElement getDone;
	
	private @FindBy(id="ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement getFrom;
	
	private @FindBy(id ="ctl00_mainContent_ddl_destinationStation1_CTNR")
	WebElement getTo;
	
	private @FindBy(xpath="//a[@value='AMD']")
	WebElement fromCity;
	
	private @FindBy(xpath ="(//a[@value='STV'])[2]")    // Index is used when having multiple elements having same xpath on the page.
	WebElement toCity;
	
	private @FindBy(xpath="//input[@id='autosuggest']")
	WebElement getautoSuggest;
	
	private @FindBy(css="input[name*='StudentDiscount']")
	WebElement slctCheck;
	
	private @FindBy(css="input[value='OneWay']")
	WebElement slctOneway;
	
	private @FindBy(css="input[value='RoundTrip']")
	WebElement slctRoundtrip;
	
	private @FindBy(css="input#ctl00_mainContent_view_date1")
	WebElement departDate;
	
	private @FindBy(css="input#ctl00_mainContent_view_date2")
	WebElement returnDate;
	
	private @FindBy(id="ctl00_mainContent_btn_FindFlights")
	WebElement searchButton;
	
	
	
	public WebElement clickPassenger()
	{
		return getPassengers;
	}
	
	public WebElement plusAdults()
	{
		return plusAdult;
	}
	
	public WebElement plusChilds()
	{
		return plusChild;
	}
	
	public WebElement minusChilds()
	{
		return minusChild;
	}
	
	public WebElement clickDone()
	{
		return getDone;
	}
	
	public WebElement getFromDropdown()
	{
		return getFrom;
	}
	
	public WebElement getFromCity()
	{
		return fromCity;
	}
	
	public WebElement getToCity()
	{
		return toCity;
	}
	
	public WebElement getToDropdown()
	{
		return getTo;
	}
	
	public WebElement enterAutoSuggest()
	{
		return getautoSuggest;
	}
	
	public WebElement checkStudent()
	{
		return slctCheck;
	}
	
	public WebElement checkOneway()
	{
		return slctOneway;
	}
	
	public WebElement checkRoundtrip()
	{
		return slctRoundtrip;
	}
	
	public WebElement selectDeptDate()
	{
		return departDate;
	}
	
	public WebElement selectReturnDate()
	{
		return returnDate;
	}
	
	public WebElement selectSearch()
	{
		return searchButton;
	}
	
}
