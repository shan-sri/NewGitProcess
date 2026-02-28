package Com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Com.DemoWebShop_POM.ErrorPage;

public class WebDriverUtility {

	public void webPaeScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenshotpath);
		FileHandler.copy(temp, dest);
		
	}
	
	public void webElementScreenShot(WebElement element) throws IOException {
		
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenshotpath);
		FileHandler.copy(temp, dest);
	}
	
	public void javaScriptClick(WebDriver driver, WebElement ele)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);	
		
	}
	
	public void javaScriptScrollToElement(WebDriver driver, WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
	}

	public void selectByVisibleText(WebElement ele, String value) {
		
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
	
		
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void error(WebDriver driver) {
		ErrorPage errorPage = new ErrorPage(driver);
		errorPage.getAdvanced().click();
		errorPage.getProceedLink().click();
	}
}
