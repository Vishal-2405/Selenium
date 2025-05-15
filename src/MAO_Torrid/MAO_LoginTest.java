package MAO_Torrid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MAO_LoginTest {
	@Test
	public void mao_LoginTest() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		String Username = "Tmodi";
		String Password = "Password123@";
		WebDriver driver = new ChromeDriver();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://trrds-auth.omni.manh.com/org_login#/order");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
		driver.findElement(By.id("login-username")).sendKeys(Username);
		driver.findElement(By.id("login-password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[value='Home']"))).click();
		
		
		
		
		
	}

}
