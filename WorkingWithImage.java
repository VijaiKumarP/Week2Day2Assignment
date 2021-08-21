package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/img")).click();
		
		if (driver.getTitle().equals("TestLeaf - Selenium Playground")) {
			System.out.println("TestLeaf - Selenium Playground : Home Page is opened");
			driver.navigate().back();
		} else {
			System.out.println("TestLeaf - Selenium Playground : Home Page is not opened");
		}
		
		//Broken image
		String attValue = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/img")).getAttribute("onclick");
		if (attValue!=null) {
			System.out.println("Image 2 is broken");
		} else {
			System.out.println("Image 2 is broken");
		}
		
		// click image using keyboard/Mouse events
		WebElement imageElement = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[3]/img"));
		
		//Actions action=new Actions(driver);
		//Point location = imageElement.getLocation();
		
		//action.moveToElement(imageElement, location.x, location.y).click().perform();

		
		imageElement.click();
		System.out.println("Completed");
	}

}
