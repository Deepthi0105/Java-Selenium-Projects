package pageobjects;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalPage {

	WebDriver driver;
	
	public static Logger log=LogManager.getLogger(FinalPage.class.getName());
	
	public FinalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='wrapperTwo']/div/select")
	WebElement selectDropdown;

	@FindBy(css = "input[type='checkbox']")
	WebElement selectCheckbox;

	@FindBy(xpath = "//div[@class='wrapperTwo']/button")
	WebElement onclickProceedBtn;

	public void enterDropBox() {

		Select dropbox = new Select(selectDropdown);
		dropbox.selectByValue("India");

	}

	public void enterCheckbox() {
		selectCheckbox.click();
	}

	public void clickOnProceedBtn() {
		onclickProceedBtn.click();
		log.info("Order Placed");
	}
	

}
