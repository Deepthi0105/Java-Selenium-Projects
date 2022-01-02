package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.MainPage;
import utils.BaseClass;

public class MainPageTest extends BaseClass {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void initialize() throws IOException {
		driver=initialization();
		driver.get(prop.getProperty("directurl"));
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void addToCart() {
		
		MainPage mp=new MainPage(driver);
		mp.addToCart();
	}

}
