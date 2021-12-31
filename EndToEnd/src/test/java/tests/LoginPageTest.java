package tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import utils.BaseClass;

public class LoginPageTest extends BaseClass {

	public static Logger log = LogManager.getLogger(LoginPage.class.getName());

	@Test(dataProvider = "getData")

	public void homePage(String uname, String password) throws IOException {

		driver = initialization();
		log.info("Driver Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Landing on Home Page");
		driver.manage().window().maximize();

		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.enterEmail("deepthi");
		lp.enterPassword("ghj@123");
		lp.onClickLogin();
		log.info("Login button clicked");

	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for hoe many different data types test should run
		// column stand for how many values per each test
		Object[][] data = new Object[2][2];
		data[0][0] = "retricted data";
		data[0][1] = "abc@123";

		data[1][0] = "non retricted";
		data[1][0] = "nvh@123";

		return data;
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}

}
