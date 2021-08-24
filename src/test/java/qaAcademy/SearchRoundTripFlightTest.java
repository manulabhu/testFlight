package qaAcademy;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FlightPageObjects;
import pageObjects.HomePageObjects;

public class SearchRoundTripFlightTest extends base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	
	@BeforeClass
	 public void initialization() throws IOException {
		    prop = new Properties();
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test(dependsOnMethods="selectRndTripRadio")
	public void selectDropdown() throws InterruptedException
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
	   // w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='book_flight']/a/span[2]")));
		HomePageObjects hp = new HomePageObjects(driver);
		hp.clickFlight().click();
		log.debug("Flight page is clicked");
		
	
		//Select Currency
		WebElement Currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	    Select dropdownCurrency = new Select(Currency);
	   // w.until(ExpectedConditions.elementSelectionStateToBe(By.id("ctl00_mainContent_DropDownListCurrency"), true));
		dropdownCurrency.selectByValue("INR");
	    Thread.sleep(2000);
	    System.out.println(dropdownCurrency.getFirstSelectedOption().getText());
	    dropdownCurrency.selectByIndex(2);
		System.out.println(dropdownCurrency.getFirstSelectedOption().getText());
		
		//Validation of Currency Selection
		String psn = dropdownCurrency.getFirstSelectedOption().getText();
		Assert.assertEquals(psn, "AED");
		
		// Select passengers
		FlightPageObjects fl = new FlightPageObjects(driver);
		fl.clickPassenger().click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
		
		for(int i=1; i<4; i++)
		{
			fl.plusAdults().click();
		}
		
		for (int j=1; j<3; j++) 
		{
			fl.plusChilds().click();
		}
		
		int k=1;
		while(k<2)
		{
			fl.minusChilds().click();
			k++;
		}
		System.out.println(fl.clickPassenger().getText());
		
		//Validation of Passengers selection.
		String passengers = fl.clickPassenger().getText();
		Assert.assertEquals(passengers, "4 Adult, 1 Child");
		log.debug(passengers + "are displayed");
		
		fl.clickDone().click();
		
		//Select destinations using dynamic drop down
		
		fl.getFromDropdown().click();
		log.debug("from drop down is clicked");
		
		fl.getFromCity().click();
		log.debug("From city selected");
		Thread.sleep(2000);
		
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='STV'])[2]")));
		fl.getToCity().click();
		log.debug("To city is selected");
		System.out.println("Test");
		
	}
	
		@Test(dependsOnMethods="selectDropdown")
		public void autoSuggestDropdown()
		{
			FlightPageObjects fl = new FlightPageObjects(driver);
			fl.enterAutoSuggest().sendKeys("ind");
			
			List<WebElement> ElementLists=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
			
			for(WebElement ElementList :ElementLists)
			{
				if(ElementList.getText().equalsIgnoreCase("India"))
				{
					ElementList.click();
					break;
				}
			}
			
		
		}
	
	
		@Test(dependsOnMethods="autoSuggestDropdown")
		public void selectCheckBox()
		{
			FlightPageObjects fl = new FlightPageObjects(driver);
			if(fl.checkStudent().isSelected())
			{
				int checkCount = driver.findElements(By.cssSelector("input[type*='checkbox']")).size();
				Assert.assertEquals(checkCount, 6);
			}
			else
			{
				fl.checkStudent().click();
				int checkCount = driver.findElements(By.cssSelector("input[type*='checkbox']")).size();
				Assert.assertEquals(checkCount, 6);
			}
		}	
			
	  @Test()
	  public void selectRndTripRadio()
	  {
		  FlightPageObjects fl = new FlightPageObjects(driver);
		  if(fl.checkRoundtrip().isSelected())
		  {
			  int radioCount = driver.findElements(By.cssSelector("input[type='radio']")).size();
			  Assert.assertEquals(radioCount, 5);
		  }
		  else
		  {
			  fl.checkRoundtrip().click();
			 // System.out.println(fl.checkRoundtrip().isSelected());
			  Assert.assertEquals(fl.checkRoundtrip().isSelected(), false);
			  int radioCount = driver.findElements(By.cssSelector("input[type='radio']")).size();
			  Assert.assertEquals(radioCount, 5);
		  }
		  
			
		}
	 
      @Test
      public void selectDates()
      {
    	  FlightPageObjects fl = new FlightPageObjects(driver);
    	  fl.selectSearch().click();
    	     	  
      }
	  
	  
	@AfterTest
	 public void tearDown()
	 {
		driver.quit();
	 }
	
	
}
