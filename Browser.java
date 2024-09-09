package Common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static String url;
	public String baseUrl;
	public static long unixTime = System.currentTimeMillis() / 1000L;

	
	public static void beforeMethod(String url, String browser) {
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				//options.addArguments("headless");// headless
				options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
						"--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");// with head
				config.driver = new FirefoxDriver(options);
			} 
			
			else if (browser.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				//options.addArguments("headless");// headless
				options.addArguments("--disable-notifications","--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
						"--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");// with head
				config.driver = new ChromeDriver(options);
			} else {
				// If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			config.driver.manage().window().maximize();
			config.driver.get(url);
		}

		catch (Exception e) {
			throw new IllegalStateException("Can't start the Chrome Web Driver", e);
		}
	}

}
