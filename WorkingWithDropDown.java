package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dropDwn1 = driver.findElement(By.id("dropdown1"));
		Select dropDwn1Sel=new Select(dropDwn1);
		
		dropDwn1Sel.selectByIndex(3);
		
		WebElement dropDwn2 = driver.findElement(By.name("dropdown2"));
		Select dropDwn2Sel=new Select(dropDwn2);
		
		dropDwn2Sel.selectByVisibleText("Appium");
		
	
		
		WebElement dropDwn3 = driver.findElement(By.id("dropdown3"));
		Select dropDwn3Sel=new Select(dropDwn3);
		
		dropDwn3Sel.selectByValue("2");

		
		WebElement dropDwn4 = driver.findElement(By.className("dropdown"));
		Select dropDwn4Sel=new Select(dropDwn4);
		
		System.out.println("Size of the Dropdown 4 is : " +dropDwn4Sel.getOptions().size());
		
		driver.findElement(By.xpath("//select[@class='dropdown']/following::select[1]")).sendKeys("UFT",Keys.ENTER);
		driver.findElement(By.xpath("//select[@class='dropdown']/following::select[2]")).sendKeys("UFT",Keys.ENTER);
		
	}

}
