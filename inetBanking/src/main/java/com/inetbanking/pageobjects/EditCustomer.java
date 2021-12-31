package com.inetbanking.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.Utils;

import com.inetbanking.utils.XLUtils;

public class EditCustomer {

	WebDriver ldriver;

	String testDataFilepath = "src/test/java/com/inetbanking/testdata/LoginData.xlsx";
	String sheet2 = "NewCustomer";

	public EditCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	WebElement linkEditCust;

	@FindBy(name = "cusid")
	WebElement textCustId;

	@FindBy(name = "AccSubmit")
	WebElement btnSubmit;
	
	@FindBy(name = "addr")
	WebElement editAddress;
	
	@FindBy(name = "city")
	WebElement editCity;
	
	
	@FindBy(name = "sub")
	WebElement clickBtnSubmit;
	

	public void clickLinkEditCust() {
		linkEditCust.click();
	}

	public void setCustIdForEdit() throws IOException {
		String value = XLUtils.getCellData(testDataFilepath, sheet2, 12, 1);
		textCustId.sendKeys(value);
	}
	
	public void clickSubmitBtn() {
		btnSubmit.click();
	}
	
	
	public void editCustAddress() {
		editAddress.sendKeys("      India");
	}
	
	public void editCustCity() {
		editCity.sendKeys("       DK");
	}
	
	public void clickSubmitBtnEditCust() {
		clickBtnSubmit.click();
	}

}
