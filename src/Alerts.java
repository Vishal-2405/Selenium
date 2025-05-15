import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String s = "Vishal";
		driver.findElement(By.id("name")).sendKeys(s);
		driver.findElement(By.id("confirmbtn")).click();
//		driver.findElement(By.id("alertbtn")).click();
//		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
//	This is click on okay
		driver.switchTo().alert().accept();
//  This is to click on cancel
		driver.switchTo().alert().dismiss();
		

		
		
		

	}

}
