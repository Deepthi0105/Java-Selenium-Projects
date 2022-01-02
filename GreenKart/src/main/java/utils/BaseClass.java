package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialization() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\workspaces\\FullFrameWork\\GreenKart\\src\\test\\resources\\utils\\config");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\workspaces\\FullFrameWork\\GreenKart\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"C:\\workspaces\\FullFrameWork\\GreenKart\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.IE.driver",
					"C:\\workspaces\\FullFrameWork\\GreenKart\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver;

	}

}
