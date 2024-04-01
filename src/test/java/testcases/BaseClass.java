package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	RemoteWebDriver driver;
	
	private ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeMethod
	public void SetUp() throws MalformedURLException, InterruptedException {

		String DriverType = System.getProperty("Browser");
		if (DriverType.contains("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (DriverType.contains("remote")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-dev-shm-using") ;
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless") ;;
			driver = new RemoteWebDriver(new URL("http://54.89.228.164:4444/"),options);
		}
		
		else {
			
			// added some comments
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-dev-shm-using") ;
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless") ;
			driver = new ChromeDriver(options);
		}
		
		SetDriver(driver);
		GetDriver().get("https://simplilearn.com/");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void TearDown() {

		GetDriver().quit();

	}
	
	public void SetDriver(RemoteWebDriver driver) {

		threadLocalDriver.set(driver);

	}
	
	public RemoteWebDriver GetDriver() {

		return threadLocalDriver.get();

	}

}
