package com.inetbanking.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.inetbanking.pageobjects.AddNewCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseTest {

	@Test
	public void addNewCustomer() throws Exception {
		
		Logger logger=Logger.getLogger(TC_AddCustomerTest_003.class);

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		AddNewCustomerPage addcust = new AddNewCustomerPage(driver);
		addcust.clickAddNewCustomerLink();

		logger.info("Providing Customer Details...");
		addcust.setCustName();
		addcust.selectCustGender();
		Thread.sleep(2000);
		addcust.setCustDob();
		Thread.sleep(2000);
		addcust.setCustAddress();
		addcust.setCustCity( );
		addcust.setCustState();
		addcust.setCustPinNo( );
		addcust.setCustMobileNo();

		String email = randomString() + "@gmail.com";
		addcust.setCustEmailId(email);

		addcust.setCustPassword();
		addcust.ClickSubmitBtn();

		Thread.sleep(5000);

		logger.info("validation started");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		

		if (result == true) {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(true);
			logger.info("test case passed");
			addcust.setCustId();
		}
		

		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}

	}

}
