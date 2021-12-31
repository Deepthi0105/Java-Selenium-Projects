package tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import utils.BaseClass;

public class ValidateNavBarTest extends BaseClass {

	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest

	public void initiliazeDriver() throws IOException {
		driver = initialization();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test

	public void validateNavigation() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getNavigationBar();
		System.out.println(hp.getNavigationBar());
		Assert.assertTrue(hp.getNavigationBar());
		log.info("Navigation displayed");
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}

}
