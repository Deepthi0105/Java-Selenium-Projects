import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.PraticePages;
import pageobjects.SignUpPage;
import utils.BaseClass;

public class LandingPageTest extends BaseClass {

	public WebDriver driver;

	@BeforeTest

	public void initialise() throws IOException {
		driver = initialization();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test

	public void validatePraticeLink() {

		LandingPage lp = new LandingPage(driver);
		lp.clickOnPractice();

	}

	@Test(timeOut=6000)
	public void validateSignUpPage()  {
		SignUpPage sp = new SignUpPage(driver);
		sp.setName("pavan");
		sp.setEmail("pshetty4@hawk.iit.edu");
		sp.enterSubmit();
	
	}

	@Test(timeOut=15000)
	public void clickOnAutomationPratice()  {
		PraticePages pp = new PraticePages(driver);
		
		pp.clickOnPratice1();
	}

	@AfterTest

	public void tearDown() {
		driver.quit();

	}

}
