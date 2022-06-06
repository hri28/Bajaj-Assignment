import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
