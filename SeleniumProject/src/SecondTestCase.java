import java.util.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",  "/Users/hrishitahri/Downloads/chromedriver-2");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		driver.findElement(By.linkText("Sign in")).click();
		
		//authenticate - add email and password before running this test!
		driver.findElement(By.id("ap_email")).sendKeys("hrishita28@icloud.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Hrish_1297");
		driver.findElement(By.id("signInSubmit")).click();
		
		//handle drop box
		//creating an object of select class
		Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
		select.selectByVisibleText("Electronics");
		
		//search for iphone12 in the searchbar, select the first search result
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 12");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div[1]/div/div")).click();
		
		//select the item
		driver.findElement(By.linkText("Apple iPhone 12 (64GB) - Blue")).click();
		
		//to switch to another tab
		String parent = driver.getWindowHandle();
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.id("add-to-cart-button")).submit();
		driver.findElement(By.linkText("Go to Cart")).click();
		
		driver.close();
		driver.switchTo().window(windows.get(0)); //switching back to the first tab
		driver.close(); //closing to first tab
	}

}
