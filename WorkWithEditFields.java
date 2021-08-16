package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithEditFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Vijaii87@gmail.com");
		
		String strAppendTxt= driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/input")).getAttribute("value");
		strAppendTxt=strAppendTxt + " Text";
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/input")).sendKeys(" Text");
		
		System.out.println(driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value"));
		
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[4]/input")).clear();
		
		System.out.println(driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[5]/input")).getAttribute("disabled"));
	}

}
