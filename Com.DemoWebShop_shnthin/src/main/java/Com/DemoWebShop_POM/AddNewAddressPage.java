package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressPage {
	
	public AddNewAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextFeild;
	
	
	@FindBy(id = "Address_LastName")
	private WebElement lastNameTextFeild;
	
	@FindBy(id = "Address_Email")
	private WebElement emailTextField;
	
	@FindBy(id ="Address_CountryId")
	private WebElement countryDD;
	
	@FindBy(id ="Address_City")
	private WebElement cityTextField;
	
	@FindBy(id="Address_Address1")
	private WebElement address1TextFeild;
	
	@FindBy(id = "Address_ZipPostalCode")
	private WebElement zipCodeTextField;
	
	@FindBy(id="Address_PhoneNumber")
	private WebElement phoneNumberTextFeild;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement savebtn;
	
	public WebElement getFirstNameTextFeild() {
		return firstNameTextFeild;
	}

	public WebElement getLastNameTextFeild() {
		return lastNameTextFeild;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryDD() {
		return countryDD;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddress1TextFeild() {
		return address1TextFeild;
	}

	public WebElement getZipCodeTextField() {
		return zipCodeTextField;
	}

	public WebElement getPhoneNumberTextFeild() {
		return phoneNumberTextFeild;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	
}

