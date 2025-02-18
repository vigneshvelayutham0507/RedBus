package trident.RedBusAutomation;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseRB {
	public static WebDriver driver;

	public void openbrwoser(String browser) {
		// String obj = browser.toLowerCase();

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("no browser found");
		}
		System.out.println("Invoked Browser is" + browser);
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");
		System.out.println();

	}

	public void setURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("Broswer is closed");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void webElementSendKeys(WebElement ele, String input, String elementName) {

		try {
			ele.sendKeys(input);
			System.out.println(input + elementName);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void webElementClick(WebElement ele, String elementName) {
		try {
			scrollToElement(ele);
			// Thread.sleep(1000);
			ele.click();
			System.out.println(elementName);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void webElementGetext(WebElement ele, String elementName) {
		try {
			String text = ele.getText();
			System.out.println(text);
			System.out.println(elementName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void multiple(List<WebElement> ele, String elementName) {
		try {
			for (int i = 0; i < ele.size(); i++) {
				ele.get(i).click();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void select(WebElement ele, String options, String input, String elementName) {
		try {
			Select select = new Select(ele);
			String str = options.toLowerCase();

			switch (str) {
			case "value":
				select.selectByValue(input);
				break;
			case "visible text":

				select.selectByVisibleText(input);

				break;

			default:
				System.out.println("enter proper input");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void autosugest(WebElement element, String inputtext, String Expectedtest, String Elementname ) {
		try {
			webElementSendKeys(element, inputtext, Elementname);
			List<WebElement> subject = driver.findElements(By.xpath("//li[contains(@class,'sc-iwsKbI jTMXri')]"));
			Thread.sleep(2000);
			for (WebElement webElement : subject) {
				if (webElement.getText().contains(Expectedtest)) {
					webElementClick(webElement, Expectedtest);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void actionclick(WebElement ele, String Elementname) {

		try {
			Actions action = new Actions(driver);
			scrollToElement(ele);
			Thread.sleep(1000);
			action.click(ele).perform();
			System.out.println(Elementname);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void doubleclick(WebElement ele, String Elementname) {
		Actions action = new Actions(driver);
		try {
			action.doubleClick(ele).perform();
			System.out.println(Elementname);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void rightclick(WebElement ele, String Elementname) {
		Actions action = new Actions(driver);
		try {
			action.contextClick(ele).perform();
			System.out.println(Elementname);

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void moveToElement(WebElement ele, String Elementname) {
		Actions action = new Actions(driver);
		try {
			action.moveToElement(ele).perform();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void scroll(int x, int y, String ele) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(" + x + "," + y + ")");
			System.out.println("Page is " + ele);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void keyBoardAction(String keyName) {
		Actions action = new Actions(driver);
		try {
			switch (keyName.toLowerCase()) {
			case "enter":
				action.keyDown(Keys.ENTER).perform();
				System.out.println(keyName + " key Clicked");
				break;

			case "keyDown":
				action.keyDown(Keys.ARROW_DOWN).perform();
				action.keyUp(Keys.ARROW_DOWN).perform();
				System.out.println(keyName + " key Clicked");
				break;

			case "keyUp":
				action.keyDown(Keys.ARROW_UP).perform();
				action.keyUp(Keys.ARROW_UP).perform();
				System.out.println(keyName + " key Clicked");
				break;

			case "shift":
				action.keyDown(Keys.SHIFT).perform();
				action.keyUp(Keys.SHIFT).perform();
				System.out.println(keyName + " key Clicked");
				break;

			case "alphabet":
				action.keyDown("a").perform();
				action.keyUp("a").perform();
				System.out.println(keyName + " key Clicked");
				break;

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void alerts(String input, String inputname, String output) {

		Alert alt = driver.switchTo().alert();
		String str = input.toLowerCase();
		switch (str) {
		case "text":
			alt.getText();
			break;
		case "accept":
			alt.accept();
			break;
		case "dismiss":
			alt.dismiss();
			break;
		case "sendkeys":
			alt.sendKeys(inputname);
			break;
		default:
			System.out.println("enter valid keys");
		}

	}
	//for click and scroll simentanously
	public void scrollToElement(WebElement element) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].scrollIntoView({Block: 'center'});", element);
	}

	public void Frames(WebElement ele, String input, String output, String ElementNAme) {
		try {
			String sss = input.toLowerCase();
			switch (sss) {
			case "id":
				driver.switchTo().frame(output);
				break;
			case "index":
				driver.switchTo().frame(Integer.parseInt(output));
				break;
			case "webelement":
				driver.switchTo().frame(ele);
				break;

			default:
				System.out.println("Provide valid input");

			}
			System.out.println("Switched to " + ElementNAme);
		} catch (Exception e) {

			System.out.println(e);
		}
	}
	
	
	public void autosugest1(WebElement element, String inputtext, String Expectedtest, String Elementname ) {
		try {
			webElementSendKeys(element, inputtext, Elementname);
			List<WebElement> subject = driver.findElements(By.xpath("//li[@class='GstStateField__StyledList-rbzf11-2 gPWEoK']"));
			Thread.sleep(2000);
			for (WebElement webElement : subject) {
				if (webElement.getText().contains(Expectedtest)) {
					webElementClick(webElement, Expectedtest);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void webElementNormalClick(WebElement ele, String elementName) {
		try {
		
			
			ele.click();
			System.out.println(elementName);

		} catch (Exception e) {
			System.out.println(e);
		}
	}


	 public void testCanvas() {
	        var canvas = driver.findElement(By.xpath("//div[text()='Lower Deck']"));
	 
	        var sizeOfCanvas = canvas.getSize();
	        var centerXOfCanvas = sizeOfCanvas.getWidth() / 2;
	        var centerYOfCanvas = sizeOfCanvas.getHeight() / 2;
	        int xCoordinateOfButton = (centerXOfCanvas / 3) * 2;
	        int yCoordinateOfButton = (centerYOfCanvas / 3) * 2;

	        
	        new Actions(driver)
	            .moveToElement(canvas, xCoordinateOfButton, yCoordinateOfButton)
	            .click()
	            .perform();	       

	 }
	 
	 
	 
	 
}


















