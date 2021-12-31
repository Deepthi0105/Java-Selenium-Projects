package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.EditCustomer;
import com.inetbanking.pageobjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseTest {

	@Test
	public void editCustomer() throws IOException, Exception {
		
		Logger logger=Logger.getLogger(TC_EditCustomerTest_004.class);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");

		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickSubmit();
		
		EditCustomer ec = new EditCustomer(driver);
		ec.clickLinkEditCust();
		Thread.sleep(3000);
		ec.setCustIdForEdit();
		logger.info("set customer id");
		Thread.sleep(3000);
		ec.clickSubmitBtn();
		logger.info("Edit Customer page");
		ec.editCustAddress();
		ec.editCustCity();
		ec.clickSubmitBtnEditCust();
		
		 boolean result=driver.getPageSource().contains("Customer details updated Successfully!!!");
		 
		 if(result==true)
		 {
			 captureScreen(driver, "editCustomer");
			 Assert.assertTrue(true);
			 logger.info("Test Case Passed- Customer added ");
		 }
		 
		 else
		 {
			 captureScreen(driver, "editCustomer");
			 Assert.assertTrue(false);
			 logger.info("Test case failed");
		 }
		 		
      Thread.sleep(5000);
	} 

}
