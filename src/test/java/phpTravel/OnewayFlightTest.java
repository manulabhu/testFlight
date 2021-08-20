package phpTravel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PhPFlightPageObjects;
import qaAcademy.base;


public class OnewayFlightTest extends base{
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	@BeforeClass
	 public void initialization() throws IOException {
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("urlphp"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			
	}
	
	@Test
	public void getFlightPage() {
		PhPFlightPageObjects php = new PhPFlightPageObjects(driver);
		php.selectFlightBtn().click();
	}
	
	@Test(dependsOnMethods="getFlightPage")
	public void onewayRadio()
	{
		
		    PhPFlightPageObjects php = new PhPFlightPageObjects(driver);
		
		  	if(php.selectonewayButton().isSelected())	
		  	{
		  		Assert.assertTrue(true);
		  	}
		  	else
		  	{
		  		php.selectonewayButton().click();
		  	}
	}
	
	@Test(dependsOnMethods="onewayRadio")
	public void selectRoute() throws InterruptedException
	{
		PhPFlightPageObjects php = new PhPFlightPageObjects(driver);
		php.autosuggestFrom().click();
		php.autosuggestFrom().sendKeys("dallas");
		Thread.sleep(3000);
		
		List<WebElement> ElementLists = driver.findElements(By.xpath("//div[@class='select2-result-label']/span"));
		
		for(WebElement ElementList:ElementLists)
		{
			if(ElementList.getText().equalsIgnoreCase("Dallas (DFW)"))
			{
				ElementList.click();
				break;
			}
		}
		
		//Validation
		String fromText = php.autosuggestFrom().getText();
		Assert.assertNotNull(fromText);
		Assert.assertEquals(fromText, "Dallas (DFW)");
		
	}
	
			
			
	


	

}
