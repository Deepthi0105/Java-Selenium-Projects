package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.FinalPage;
import pageobjects.MainPage;
import pageobjects.ProceedToCheckout;
import pageobjects.PromoCodePage;
import utils.BaseClass;

public class MainPageTest extends BaseClass {

	WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
		driver = initialization();
		driver.get(prop.getProperty("directurl"));
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void addToCart() {

		MainPage mp = new MainPage(driver);
		mp.addToCart();
	}

	@Test(priority = 2)
	public void validateProceedToCheckout() {
		ProceedToCheckout pc = new ProceedToCheckout(driver);
		pc.clickingOnImage();
		pc.clickingOnProceed();
	}

	@Test(priority = 3)
	public void validatePromoCode() {
		PromoCodePage pc = new PromoCodePage(driver);
		pc.enterPromoCode("rahulshettyacademy");
		pc.clickOnApply();
		Assert.assertEquals(pc.getPromoInfo(), "Code applied ..!");
		pc.clickOnPlaceOrder();
	}

	@Test(priority = 4)
	public void validateFinalPage() {

		System.out.println("-->");
		FinalPage fp = new FinalPage(driver);
		fp.enterDropBox();
		fp.enterCheckbox();
		fp.clickOnProceedBtn();

	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}
