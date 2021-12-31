package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.log4testng.Logger;

import com.inetbanking.pageobjects.DeleteCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseTest {
	
	public void deleteCust() throws IOException
	{
		Logger logger=Logger.getLogger(TC_DeleteCustomerTest_005.class);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");

		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickSubmit();
		
		DeleteCustomerPage dc= new DeleteCustomerPage(driver);
		dc.clickLinkDelCust();
		dc.setCustId();
		dc.clickSubBtn();
		logger.info("Customer Deleted successfully");
		
	}

}
