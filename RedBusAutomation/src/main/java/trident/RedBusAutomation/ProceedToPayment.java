package trident.RedBusAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProceedToPayment extends BaseRB {
	
	@ FindBy(xpath = "//div[@class='radio-unchecked']")
	private WebElement BDP;

	@ FindBy(xpath = "//button[text()='continue']")
	private WebElement continuebutton;
	
	@FindBy(xpath ="//button[@class='button continue inactive']")
	private WebElement proceedtobook;
	
	@ FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement Name;
	
	@ FindBy (xpath = "//div[@id='div_22_0']")
	private WebElement Gender;
	
	@ FindBy(xpath = "//input[@placeholder='Age']")
	private WebElement Age;
	
	@ FindBy (xpath = "//input[@class='GstStateField__InputBox-rbzf11-6 iPALMK']")
	private WebElement State;
	
	@ FindBy (xpath ="//input[@placeholder='Email ID']")
	private WebElement EmailID;
	
	@ FindBy( xpath = "//input[@placeholder='Phone']")
	private WebElement MobileNumber;
	
	@ FindBy(xpath = "//input[@class='refundCheckBox']")
	private WebElement refundbutton;
	
	@ FindBy(xpath = "//input[@value='no']")
	private WebElement AssuranceButton;
	
	@ FindBy(xpath = "//input[@value='Proceed to pay']")
	private WebElement proceedtopay;





	
	
	
	public  ProceedToPayment(){
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		 
	 }
	
	public void ProceedToPaymentFunction() {
		
		new BaseRB().webElementNormalClick(BDP, "bdp is clicked");
		new BaseRB().webElementNormalClick(continuebutton, "contine button is clicked");
		new BaseRB().webElementNormalClick(proceedtobook, "proceed to book button is clicked");
		new BaseRB().webElementSendKeys(Name, "Vignesh", "name is provided");
		new BaseRB().webElementNormalClick(Gender, "Gender male is selected");
		new BaseRB().webElementSendKeys(Age, "21", "age is provided");
		new BaseRB().autosugest1(State, "Tamil", "Tamil Nadu", "State input is provided");
		new BaseRB().webElementSendKeys(EmailID, "vickyvelayutham58@gmail.com", "user email id is provided");
		new BaseRB().webElementSendKeys(MobileNumber, "9655047449", "mobile number is provided");
		new BaseRB().webElementNormalClick(refundbutton, "refenund button is clicked");
		new BaseRB().webElementNormalClick(AssuranceButton, "Assurance button is clicked");
		new BaseRB().webElementNormalClick(proceedtopay, "proceed to pay button is clicked");
	}
		
	}

