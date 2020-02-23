package com.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

	private WebDriver driver;
	private static String driverPath = "D:\\Drivers\\";

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		if(browserType.equalsIgnoreCase("Chrome")) {
			driver = initChromeDriver(appURL);
		}
		if(browserType.equalsIgnoreCase("Firefox")) {
			driver = initFirefoxDriver(appURL);
		}
		if(browserType.equalsIgnoreCase("IE")) {
			driver = initIEDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Gecko browser..");
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching IE browser..");
		System.setProperty("webdriver.internetexplorer.driver", "D:\\Drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) throws IOException {
		/*FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"//OR//confg.properties");
		Properties prop = new Properties();
		prop.load(fin);*/
		try {
			//setDriver(prop.getProperty(browserType), prop.getProperty(appURL));
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}