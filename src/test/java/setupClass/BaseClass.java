package setupClass;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String browserName;
	public static Logger log;
	public static WebElement webelement;
	public static String local_chrome;
	public static String local_FFbrowser;
	public static WebDriverWait wait;
	static String errorLog;
	public static JavascriptExecutor js;

	@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("config//config.properties"));
		AppURL = property.getProperty("App_url");
		local_chrome = property.getProperty("local_chrome");
		local_FFbrowser = property.getProperty("local_FFbrowser");
		// on source lab setup
		AppURL = property.getProperty("App_url");
		System.out.println("url ---" + AppURL);

		if ((local_chrome.equals("yes"))) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			options.addArguments("--incognito"); // DesiredCapabilities object
			DesiredCapabilities c = DesiredCapabilities.chrome(); // set capability to
			c.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(options);

			driver.manage().window().maximize();

			driver.get(AppURL);
			driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 30);
			js = (JavascriptExecutor) driver;
		}
		// if (browser.equalsIgnoreCase("firefox"))

		// if (browser.equalsIgnoreCase("chrome"))
		else if ((local_FFbrowser.equals("yes"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 30);
			js = (JavascriptExecutor) driver;

			Thread.sleep(1000);
		} else {

			System.out.println("platform does not provide");
		}

	}

	public static void ClearBrowserCache() throws Throwable {

		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public static WebElement elementToBeClickable(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement precenceOfElement(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void checkConsoleError() throws InterruptedException, IOException {

		String path = System.getProperty("user.dir");
		// System.out.println("path = " + path);
		BufferedWriter printlog = new BufferedWriter(new FileWriter(path + "\\console error.txt"));
	//	PrintStream printlog = new PrintStream(path + "\\console error.txt");
		// check console error
		List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
		
			for (LogEntry entry : logs) {

				errorLog = entry.getMessage().toString();

				System.out.println(driver.getCurrentUrl() + "   ---------------" + new Date(entry.getTimestamp())
						+ "-------- " + entry.getLevel() + "--- " + entry.getMessage());

				printlog.append(new Date(entry.getTimestamp()) + "---" + driver.getCurrentUrl() + "---"
						+ entry.getLevel() + "---" + entry.getMessage() + "---" + System.getProperty("line.separator"));
			}
		
		printlog.append(System.getProperty("line.separator"));
		printlog.append(System.getProperty("line.separator"));
		printlog.close();
		Thread.sleep(2000);

	}

	@AfterClass
	public static void after_Class() throws InterruptedException {
		Thread.sleep(2000);

		if (driver != null) {
			// driver.quit(); // ->> don't want to close the browser
			Thread.sleep(2000);
		}

	}

}
