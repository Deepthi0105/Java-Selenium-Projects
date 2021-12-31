package com.inetbanking.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.utils.XLUtils;

public class DeleteCustomerPage {
	
	WebDriver ldriver;
	
	String testDataFilepath = "src/test/java/com/inetbanking/testdata/LoginData.xlsx";
	String sheet2 = "NewCustomer";
	
	public DeleteCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[4]/a")
	WebElement linkDelCust;
	
	@FindBy(name="cusid")
	WebElement txtCustId;
	
	@FindBy(name = "AccSubmit")
	WebElement btnSubmit;
	
	public void clickLinkDelCust()
	{
		linkDelCust.click();
	}
	
	public void setCustId() throws IOException
	{
		String value=XLUtils.getCellData(testDataFilepath, sheet2, 12, 1);
		txtCustId.sendKeys(value);
	}
	
	public void clickSubBtn()
	{
		btnSubmit.click();
	}

}
