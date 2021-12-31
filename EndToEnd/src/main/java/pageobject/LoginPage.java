package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='m-b-4-xs']//input[@id='email']")
	WebElement emailTextField;

	@FindBy(css = "input[name='password']")
	WebElement passwordTextField;

	@FindBy(css = "input[type='submit']")
	WebElement clickOnLoginBtn;

	public void enterEmail(String email) {
		emailTextField.sendKeys(email);

	}

	public void enterPassword(String pass) {
		passwordTextField.sendKeys(pass);
	}

	public void onClickLogin() {
		clickOnLoginBtn.click();
	}

}
