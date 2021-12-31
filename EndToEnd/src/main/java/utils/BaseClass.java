package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
				"C:\\workspaces\\FullFrameWork\\EndToEnd\\src\\test\\resources\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\workspaces\\FullFrameWork\\EndToEnd\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"C:\\workspaces\\FullFrameWork\\EndToEnd\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.IE.driver",
					"C:\\workspaces\\FullFrameWork\\EndToEnd\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);// file in virtual name
		String destFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png"; // get file to local
																									// system
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}

}
