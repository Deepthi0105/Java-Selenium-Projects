package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromoCodePage {

	WebDriver driver;

	public PromoCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[class='promoCode']")
	WebElement textdfieldPromo;

	@FindBy(css = "button[class='promoBtn']")
	WebElement onclickApply;

	@FindBy(css = "span[class='promoInfo']")
	WebElement getPromoInfo;

	@FindBy(xpath = "//div//button[text()='Place Order']")
	WebElement onclickPlaceOrder;

	public void enterPromoCode(String promo) {
		textdfieldPromo.sendKeys(promo);
	}

	public void clickOnApply() {
		onclickApply.click();
	}

	public String getPromoInfo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		return getPromoInfo.getText();

	}

	public void clickOnPlaceOrder() {
		onclickPlaceOrder.click();
	}

}
