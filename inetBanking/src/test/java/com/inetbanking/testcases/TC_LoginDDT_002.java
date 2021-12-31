package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002  extends BaseTest {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user_name, String password) throws Exception {
		
		Logger logger=Logger.getLogger(TC_LoginDDT_002.class);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user_name);
		logger.info("User name provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			
		} 
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() // User defined method created to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() {
		try {
			String path = "src/test/java/com/inetbanking/testdata/LoginData.xlsx";
			
			int rownum = XLUtils.getRowCount(path, "Sheet1");
			int colcount;
		
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
			String logindata[][] = new String[rownum][colcount];

			for (int i = 1; i < rownum; i++) {
				for (int j = 0; j < colcount; j++) {
					logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				}
			}
			return logindata;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
