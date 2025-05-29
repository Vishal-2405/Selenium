import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class byPassCaptcha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.start(0);

		proxy.addRequestFilter((request, contents, messageInfo) -> {
		    request.headers().add("x-belk-automation", "BelkQATestAutomationLT");
		    return null;
		});

		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setProxy(seleniumProxy);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		String email = "belktestemailtestoffshore10042@gmail.com";
		String Pwd = "Belktestsku@123";
		driver.manage().window().maximize();
		driver.get("https://www.belkdev.com/");
		driver.findElement(By.id("person-dot")).click();			
		driver.findElement(By.xpath("//sh-button[@link='https://www.belkdev.com/account/']//button[@role='link']")).click();
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Pwd);		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(1));
	}

}
