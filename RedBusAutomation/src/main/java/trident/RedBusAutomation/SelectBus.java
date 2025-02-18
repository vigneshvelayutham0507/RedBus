package trident.RedBusAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SelectBus extends BaseRB {



	@ FindBy(xpath = "//label[@title='After 6 pm']")
	private WebElement DepatureTime;
	////input[@id='dtAfter 6 pm']

	@ FindBy(xpath = "//label[@title='SLEEPER']")
	private WebElement Bustype;

	@ FindBy(xpath= "//label[@title='Single Seats']")
	private WebElement SeatAvailablity;

	@ FindBy(xpath = "//input[@placeholder='BOARDING POINT']")
	private WebElement boardingPoint;

	@ FindBy(xpath ="//label[@title='Koyambedu']")
	private WebElement BoardingPlace;

	@ FindBy(xpath ="//div[text()='APPLY']")
	private WebElement ApplyBoardingplace;

	@ FindBy(xpath = "//div[@class='button view-seats fr']")
	private WebElement ClickSelectSeat;

	





	public SelectBus(){
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

	}

	public void SelectBusfunction() throws InterruptedException{
		Thread.sleep(1500);
		new BaseRB().webElementNormalClick(DepatureTime, "Depature Time is Clicked");
		new BaseRB().scroll(0, 200, "scrolled");
		new BaseRB().webElementNormalClick(Bustype, "Type of The Bus is Clicked");
		new BaseRB().webElementNormalClick(SeatAvailablity, "Seat Availablity is clicked");

		new BaseRB().webElementNormalClick(boardingPoint, "Boarding Point is Clicked");
		new BaseRB().webElementNormalClick(BoardingPlace, "Boarding Place Is Clicked");
		new BaseRB().webElementNormalClick(ApplyBoardingplace, "Apply Button For Boarding place Is Clicked");
		new BaseRB().scroll(0, 100, "Scrolled");
		new BaseRB().webElementNormalClick(ClickSelectSeat, "select seat button is clicked");
		
		Thread.sleep(3000);
		
		System.out.println();
		

}
	
	
	
}
