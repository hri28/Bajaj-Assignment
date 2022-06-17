import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class ThirdTestCase {
	
	@Test
	public void CleartripTestCase() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",  "/Users/hrishitahri/Downloads/chromedriver-2");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cleartrip.com/flights");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[7]/button")).click();
		
		WebElement userid = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/input"));
		userid.click();
		userid.sendKeys("hrishita282001@gmail.com");
		
		WebElement userpass = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[1]/input"));
		userpass.click();
		userpass.sendKeys("Hrish&ya2");
		
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/input")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/input")).sendKeys("hrishita282001@gmail.com");
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[1]/input")).click();
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[1]/input")).sendKeys("Hrish&ya2");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[8]/button[1]")).click();
		
		driver.findElement(By.xpath("#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba.h-fc > div > div.flex.flex-between.flex-middle.px-4.mt-2.mb-4 > label:nth-child(2) > div.flex.flex-start.p-relative.flex-middle > input")).click();
		

	}

}
