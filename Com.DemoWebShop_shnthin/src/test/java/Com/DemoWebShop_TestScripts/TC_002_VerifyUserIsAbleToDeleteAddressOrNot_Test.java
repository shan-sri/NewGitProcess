package Com.DemoWebShop_TestScripts;

import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.AddressesPage;

public class TC_002_VerifyUserIsAbleToDeleteAddressOrNot_Test extends BaseTest {
	@Test
	public void addAddress() throws InterruptedException  {
		
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver, homePage.getAddressbtn());
		homePage.getAddressbtn().click();
		
		AddressesPage addressesPage = new AddressesPage(driver);
		addressesPage.getDeleteBtn().click();
		
		Thread.sleep(2000);
		webDriverUtility.alertAccept(driver);
		
	}

}
