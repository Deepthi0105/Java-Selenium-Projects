package tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import utils.BaseClass;

public class HomePageTitleTest extends BaseClass {
	
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest

	public void initiliazeDriver() throws IOException {
		driver = initialization();
		log.info("Driver Initialised");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test

	public void validatingHomePageTitle() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getTitle();
		Assert.assertEquals(hp.getTitle(), "123Featured588Courses");
		log.info("Validation Successfull");

	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}
