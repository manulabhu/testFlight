package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageObjects {
	
public WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Defining objects variable to private and methods to public is encapsulation aspect of class so we are hiding web element data to this class only and methods to public so other class can still use it on LandingPage
	
		private @FindBy(xpath="//li[@class='book_flight']/a/span[2]")
		WebElement getFlight;
		
		/*private @FindBy(id="ctl00_mainContent_DropDownListCurrency")
		WebElement Currency;
		Select dropdownCurrency = new Select (Currency);*/
		
		
	
		
		
		
		
		
		public WebElement clickFlight()
		{
			System.out.println("Flight tab is clicked");
			return getFlight;
		}
		
		/*public Select getCurrency()
		{
			System.out.println("Currency tab is clicked");
			return dropdownCurrency;
		}*/

		
	
}
