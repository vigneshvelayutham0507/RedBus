package trident.RedBusAutomation;

import java.time.Duration;


public class RBexcute extends BaseRB {
	static String browser = "chrome";
	static String URl = "https://www.redbus.in/";

	public static void main(String[] args) throws InterruptedException {
		new BaseRB().openbrwoser(browser);
		new BaseRB().setURL(URl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		new HomePageRB().HPfunctionRB();
		new SelectBus().SelectBusfunction();
		new ProceedToPayment().ProceedToPaymentFunction();

	}


}
