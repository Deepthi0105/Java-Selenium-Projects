package com.inetbanking.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.inetbanking.utils.XLUtils;

public class AddNewCustomerPage {

	WebDriver ldriver;
	String testDataFilepath = "src/test/java/com/inetbanking/testdata/LoginData.xlsx";
	String sheet2="NewCustomer";
	
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement addNewCustomerLink;

	@FindBy(how = How.NAME, using = "name")
	WebElement txtCustName;

	@FindBy(how = How.NAME, using = "rad1")
	List<WebElement> radioGenders;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtPinNo;

	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txtMobileNo;

	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtEmailId;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	WebElement custId;
	
	

	public void clickAddNewCustomerLink() {
		addNewCustomerLink.click();
	}

	public void setCustName() throws IOException {
		String custName=XLUtils.getCellData(testDataFilepath, sheet2, 1, 1);
		txtCustName.sendKeys(custName);
	}

	public void selectCustGender() throws IOException {
		
		String f=XLUtils.getCellData(testDataFilepath, sheet2, 2, 1);
		// when done by name, we get list of Radio buttons
		for (WebElement radio : radioGenders) {
//	        if (radio.getText().equals(custGender)) {
//	            radio.click();
//	        }
	        if (radio.getAttribute("value").equals(f)) {
	            radio.click();
	        }
	    }
	}

	public void setCustDob() throws IOException {
		String dob=XLUtils.getCellData(testDataFilepath, sheet2, 3, 1);
		txtdob.sendKeys(dob);
	}

	public void setCustAddress() throws IOException {
		String custAddress = XLUtils.getCellData(testDataFilepath, sheet2, 4, 1);
		txtAddress.sendKeys(custAddress);
	}

	public void setCustCity() throws IOException {
		String custCity=XLUtils.getCellData(testDataFilepath, sheet2, 5, 1);
		txtCity.sendKeys(custCity);
	}

	public void setCustState() throws IOException {
		String custState=XLUtils.getCellData(testDataFilepath, sheet2, 6, 1);
		txtState.sendKeys(custState);

	}

	public void setCustPinNo( ) throws IOException {
		String custPinNo=XLUtils.getCellData(testDataFilepath, sheet2, 7, 1);
		txtPinNo.sendKeys(custPinNo);

	}

	public void setCustMobileNo() throws IOException {
		String custMobileNo=XLUtils.getCellData(testDataFilepath, sheet2, 8, 1);
		txtMobileNo.sendKeys(custMobileNo);
	}

	public void setCustEmailId(String custEmail) throws IOException {
		txtEmailId.sendKeys(custEmail);
	}

	public void setCustPassword() throws IOException {
		String custPassword=XLUtils.getCellData(testDataFilepath, sheet2, 10, 1);
		txtPassword.sendKeys(custPassword);
	}

	public void ClickSubmitBtn() {
		btnSubmit.click();
	}
	
	public void setCustId() throws IOException {
		XLUtils.setCellData(testDataFilepath, sheet2, 12, 1,custId.getText() );
	}
}
