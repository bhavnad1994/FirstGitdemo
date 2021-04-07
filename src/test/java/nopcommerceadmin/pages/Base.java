package nopcommerceadmin.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	public static WebDriver driver;
	public static Properties prop;
	final String filePath = "/nopcommerceAdmin/src/test/java/configurationFiles/config.properties";

	public Base() {
		try {
			prop = new Properties();
			InputStream input = new FileInputStream(filePath);
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setup() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("Chromedriverpath"));
			driver = new ChromeDriver();
		}

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("Geckodriverpath"));
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public void tearDown() {
		driver.quit();
	}

}
