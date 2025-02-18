package trident.RedBusAutomation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageRB extends BaseRB {
	@ FindBy (xpath = "//input[@id='src']")
	private WebElement From;

	@ FindBy (xpath = "//input[@id='dest']")
	private WebElement To;

	@ FindBy (xpath = "//span[text()='Date']")
	private WebElement calender;


	//	@FindBy (xpath = "//div[contains(@class,'DayNavigator__Ico')][3]")
	//	private WebElement nextMonth;

	//	
	@ FindBy (xpath = "//button[@id='search_button']")
	private WebElement SearchIcon;








	public HomePageRB(){
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}



	public void HPfunctionRB() throws InterruptedException {

		new BaseRB().autosugest(From, "ch", "CMBT, Chennai, Chennai", "From Place is Selected From The DropDown" );
		new BaseRB().webElementNormalClick(From, "From place is Clicked");

		new BaseRB().autosugest(To, "pon", "Pondicherry", "To Place Pondichery is Selected");

		new BaseRB().webElementNormalClick(To,"To Place is Clicked");

		new BaseRB().webElementNormalClick(calender, "Date Icon is Clicked");

		//new BaseRB().webElementNormalClick(nextMonth, "Next month icon is clicked");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 3); 
		String output = sdf.format(c.getTime());
		System.out.println(output);
		String[] fullFutureDate = output.split("/");

		String futureDate = fullFutureDate[0];

		System.out.println( futureDate); 

		WebElement ClickDate = driver.findElement(By.xpath("//span[text()='"+futureDate+"']"));

		new BaseRB().webElementNormalClick(ClickDate, "TripDate Is Selected");
		new BaseRB().webElementNormalClick(SearchIcon, "Search Icon Is clicked");
		System.out.println();



	}
}
