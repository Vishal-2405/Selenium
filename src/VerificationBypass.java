import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Headers;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerificationBypass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
	//	WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver(options);
		
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		Map<String, Object> headers = new HashMap<>();
		headers.put("x-belk-automation", "BelkQATestAutomationLT");

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		
		String email = "belktestemailtestoffshore10042@gmail.com";
		String Pwd = "Belktestsku@123";
		driver.manage().window().maximize();
		driver.get("https://www.belkdev.com/");
		driver.findElement(By.id("person-dot")).click();
			
		
		driver.findElement(By.xpath("//sh-button[@link='https://www.belkdev.com/account/']//button[@role='link']")).click();
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Pwd);		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[token='48a66afb5b9126b62f5a8788f9d804e718a19aeb07df2fe5ee046cb7efdfb0d91f530a0064d6e9394b3035810a3b826d02138c0030be4dfa64a315d625d418a0']")));
		WebElement e= driver.findElement(By.cssSelector("iframe[token='48a66afb5b9126b62f5a8788f9d804e718a19aeb07df2fe5ee046cb7efdfb0d91f530a0064d6e9394b3035810a3b826d02138c0030be4dfa64a315d625d418a0']"));
		Actions a = new Actions(driver);
		a.clickAndHold(e).perform();
		
		
		
	}

}
