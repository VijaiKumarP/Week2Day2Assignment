package Week2.Day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public void checkBusType(List<WebElement> mWebElement, String mBusType, String mAction) {
		mAction=mAction.toUpperCase();
		switch (mAction) {
		case "SELECT":
			for (WebElement webElement : mWebElement) {	
				if (webElement.getAttribute("for").contains(mBusType)) {
					//if (webElement.isSelected()==false) {
					webElement.click();
					//}
					break;
				}
			}			
			break;
		case "DESELECT":
			for (WebElement webElement : mWebElement) {	
				if (webElement.getAttribute("for").contains(mBusType)) {
					//if (webElement.isSelected()==true) {
						webElement.click();
					//}
					break;
				}
			}				
			break;
		default:
			break;
		}
	}
	
	public void scrollDown(int downCount) throws AWTException {
		
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		for (int i = 0; i < downCount; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
		}		 
	}
	
	public void scrollBy(ChromeDriver driver, int scrolPos) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0," + scrolPos +")");
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("src")).sendKeys("Chennai");
		Thread.sleep(1000);
		driver.findElement(By.id("src")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		Thread.sleep(1000);
		driver.findElement(By.id("dest")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(1000);
		List<WebElement> dayObj = driver.findElements(By.xpath("//td[@class='wd day']"));
		String selDate="25";
		for (WebElement webElement : dayObj) {
			//System.out.println("Date : " + webElement.getText());
			if (webElement.getText().equals(selDate)) {
				webElement.click();
				break;
			}
		}
		
		driver.findElement(By.id("search_btn")).click();
		
		Thread.sleep(2000);
		
		System.out.println("No of Busses Available : " +driver.findElement(By.xpath("//div[@class='f-bold ']")).getText());
		
		RedBus redbus=new RedBus();
		
		// Sleeper Bus
		Thread.sleep(2000);
		redbus.scrollBy(driver, 250);
		redbus.checkBusType( driver.findElements(By.className("custom-checkbox")), "SLEEPER", "SELECT");
		System.out.println("No of Sleeper Buses Available : " +driver.findElement(By.xpath("//div[@class='f-bold ']")).getText());
		
		// Deselect Sleeper and select AC
		
		redbus.scrollBy(driver, 250);
		redbus.checkBusType( driver.findElements(By.className("custom-checkbox")), "SLEEPER", "DESELECT");
		Thread.sleep(1000);
		redbus.scrollBy(driver, 250);
		redbus.checkBusType( driver.findElements(By.className("custom-checkbox")), "AC", "SELECT");
		System.out.println("No of only AC Buses Available : " +driver.findElement(By.xpath("//div[@class='f-bold ']")).getText());
		
		// AC & Non Ac busses 
		
		redbus.scrollBy(driver, 250);
		redbus.checkBusType( driver.findElements(By.className("custom-checkbox")), "NONAC", "SELECT");
		System.out.println("No of AC & Non AC Buses Available : " +driver.findElement(By.xpath("//div[@class='f-bold ']")).getText());
		
	}

}
