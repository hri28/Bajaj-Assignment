import java.util.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SecondTestCase {
	
	@Test
	public void AmazonTestCase() throws InterruptedException {
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
		driver.close(); //closing the first tab
	}
	
	@Test
	public void BajajTestCase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/hrishitahri/Downloads/chromedriver-2");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		WebElement webSearch = driver.findElement(By.name("q"));
		webSearch.sendKeys("Bajaj Finserv Health Limited");
		webSearch.sendKeys(Keys.ENTER);
		
		//to search from the list of search results
//		driver.findElement(By.name("q")).sendKeys("Bajaj Finserv Health Limited");
//		Thread.sleep(5000);		
//		List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='pcTkSc']"));
////		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			String listitem = list.get(i).getText();
//			if(listitem.contains("Bajaj Finserv Health Limited")) {
//				list.get(i).click(); //loop through the list of suggestions until the given string is found and click on it,
//				break;
//			}
//		}
		
		driver.findElement(By.cssSelector("a[href='https://www.bajajfinservhealth.in/']")).click();

		driver.findElement(By.id("searchBarInput")).sendKeys("Doctor");
		Thread.sleep(3000); //halts current execution of thread, using to wait for search results
		driver.findElement(By.xpath("//*[@id=\"searchBarWrapperContainer\"]/div/div[2]/div/div[2]/p/span[1]/span[1]")).click();
		driver.findElement(By.linkText("6:45 PM")).click();
		
		driver.close();
		}
	

}
