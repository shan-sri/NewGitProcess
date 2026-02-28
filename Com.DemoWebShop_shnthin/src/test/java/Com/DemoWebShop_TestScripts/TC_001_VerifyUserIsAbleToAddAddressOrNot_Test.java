package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import Com.DemoWebShop_GenericUtility.BaseTest;

import Com.DemoWebShop_POM.AddNewAddressPage;
import Com.DemoWebShop_POM.AddressesPage;

public class TC_001_VerifyUserIsAbleToAddAddressOrNot_Test extends BaseTest {
	
	@Test
	
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException{
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver, homePage.getAddressbtn());
		homePage.getAddressbtn().click();
		
		AddressesPage addressesPage = new AddressesPage(driver);
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver, addressesPage.getAddNewBtn());
		addressesPage.getAddNewBtn().click();
		
		AddNewAddressPage newAddressPage=new AddNewAddressPage(driver);
		newAddressPage.getFirstNameTextFeild().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		newAddressPage.getLastNameTextFeild().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		newAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		
		webDriverUtility.selectByVisibleText(newAddressPage.getCountryDD(),
				fileUtility.readDataFromExcelFile("sheet1", 1, 3));
		
		newAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		newAddressPage.getAddress1TextFeild().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		newAddressPage.getZipCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		newAddressPage.getPhoneNumberTextFeild().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		newAddressPage.getSavebtn().click();
		Thread.sleep(3000);
		webDriverUtility.webPaeScreenshot(driver);
	}
}
