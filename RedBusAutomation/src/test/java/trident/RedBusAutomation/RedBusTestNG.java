package trident.RedBusAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.testng.annotations.AfterSuite;

public class RedBusTestNG extends BaseRB {
	static String browser = "chrome";
	static String URl = "https://www.redbus.in/";
  @Test
  public void f() {
  }
  @BeforeSuite
  public void beforeSuite() {
	  
	  new BaseRB().openbrwoser(browser);
		new BaseRB().setURL(URl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }
@Test
public void HomePage() throws InterruptedException {
	new HomePageRB().HPfunctionRB();
}

@Test
public void SelectBus() throws InterruptedException {
	new SelectBus().SelectBusfunction();
}
  
  
  @AfterSuite
  public void afterSuite() {
	  new ProceedToPayment().ProceedToPaymentFunction();
  }

}
