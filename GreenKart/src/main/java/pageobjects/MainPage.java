package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	
	public static Logger log=LogManager.getLogger(MainPage.class.getName());

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String[] veggiesNeeded = { "cucumber", "tomato", "potato", "onion", "banana" };

	@FindBy(css = "h4[class='product-name']")
	List<WebElement> listOfProducts;

	@FindBy(xpath = "//div[@class='product-action']/button")
	List<WebElement> addToCart;

	public void addToCart() {
		int j = 0;
		for (int i = 0; i < listOfProducts.size(); i++) {
			String[] productName = listOfProducts.get(i).getText().split("-");
			String formattedName = productName[0].trim().toLowerCase();

			List<String> itemsNeeded = Arrays.asList(veggiesNeeded);

			if (itemsNeeded.contains(formattedName)) {
				j++;
				addToCart.get(i).click();
			}
			if (j == veggiesNeeded.length) {
				break;
			}

		}
		log.info("Items added to the cart");
	}

}
