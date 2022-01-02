package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='name']")
	WebElement textFieldName;

	@FindBy(css = "input[id='email']")
	WebElement textFieldEmail;

	@FindBy(css = "button[id='form-submit']")
	WebElement enterSubmitBtn;

	public void setName(String name) {
		textFieldName.sendKeys(name);
	}

	public void setEmail(String email) {
		textFieldEmail.sendKeys(email);
	}

	public void enterSubmit() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(enterSubmitBtn));
		enterSubmitBtn.click();
	}

}
