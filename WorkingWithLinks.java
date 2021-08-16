package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Link 1
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		if (driver.getTitle().equals("TestLeaf - Selenium Playground")) {
			System.out.println("TestLeaf - Selenium Playground : Home Page is opened");
		} else {
			System.out.println("TestLeaf - Selenium Playground : Home Page is not opened");
		}
		
		driver.navigate().back();
		
		
		//Link 2
		System.out.println("Second Link will take you to : " +driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/a")).getAttribute("href"));
		
	
		//Link 3
		if (driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href").contains("error")) {
			System.out.println("Third Link is broken");
		}
		
		//Link 4
		String link1 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		String link2 = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[4]/a")).getAttribute("href");
		if (link1.equals(link2)){
			System.out.println("First Link and Last Link Interact with the Same URL");
		}else {
			System.out.println("Link is not Same");
		}
		
		System.out.println("Total Links Available in the website is : " +driver.findElements(By.tagName("a")).size());
		driver.close();
		
		
		
	}

}
