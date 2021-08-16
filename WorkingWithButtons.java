package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		if (driver.getTitle().equals("TestLeaf - Selenium Playground")) {
			System.out.println("TestLeaf - Selenium Playground : Home Page is Opened");
		}else {
			System.out.println("TestLeaf - Selenium Playground : Home Page is not Opened");
		}
		
		driver.navigate().back();
		
		System.out.println(" (X,Y) position of the Second button : " +driver.findElement(By.xpath("//button[@id='position']")).getLocation());
		
		System.out.println("Color of the third button : " +driver.findElement(By.xpath("//button[@id='color']")).getAttribute("style"));
		
		System.out.println("(Length,Height) Size of the Fourth button : " +driver.findElement(By.xpath("//button[@id='color']")).getSize());
		
		driver.close();
	}

}
