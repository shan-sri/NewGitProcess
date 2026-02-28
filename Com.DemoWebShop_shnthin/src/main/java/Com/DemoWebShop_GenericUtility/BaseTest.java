package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.HomePage;
import Com.DemoWebShop_POM.LoginPage;
import Com.DemoWebShop_POM.WelcomePage;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileUtility = new FileUtility();
	public WelcomePage welcomePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public WebDriverUtility webDriverUtility = new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("DataBase Connected");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Report started");

		spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("DemoWebShop");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Launch browser");

		//String browser = fileUtility.readDataFromPropertFile("browserName");
		//String baseurl = fileUtility.readDataFromPropertFile("url");
		
		String baseurl = System.getProperty("url");
		String browser = System.getProperty("browserName");
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			System.out.println("enter valid browser Name");
		}

		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(baseurl);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Login");

		// webDriverUtility.error(driver);
		welcomePage = new WelcomePage(driver);
		welcomePage.getLoginbtn().click();

		loginPage = new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertFile("password"));
		loginPage.getLoginBtn().click();

		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Logout");

		homePage.getLogOutBtn().click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("close browser");

		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Report Ended");
		reports.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("DataBase disConnected");
	}

}
