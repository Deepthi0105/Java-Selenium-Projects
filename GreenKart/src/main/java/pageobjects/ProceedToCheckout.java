package pageobjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedToCheckout {

	WebDriver driver;
	public static Logger log=LogManager.getLogger(ProceedToCheckout.class.getName());

	public ProceedToCheckout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "img[alt='Cart']")
	WebElement onClickImage;

	@FindBy(xpath = "//div[@class='action-block']//button[@type='button']")
	WebElement onClickProceed;

	public void clickingOnImage() {
		onClickImage.click();
	}

	public void clickingOnProceed() {
		onClickProceed.click();
		log.info("Proceeded to checkout");
	}
}
