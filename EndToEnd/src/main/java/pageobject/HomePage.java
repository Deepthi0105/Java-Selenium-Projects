package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='theme-btn register-btn']")
	WebElement clickOnLogin;

	@FindBy(xpath = "//div[@class='pull-left'] /h2")
	WebElement validatinggetTitle;
	
	@FindBy(xpath = "//ul[@class='navigation clearfix']")
	WebElement navBars;

	public void clickLogin() {
		clickOnLogin.click();
	}

	public String getTitle() {
		return validatinggetTitle.getText();
	}
	
	public boolean getNavigationBar()
	{
		return navBars.isDisplayed();
	}


}
