import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) throws InterruptedException {
//		 TODO Auto-generated method stub
//		Security socket layer		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		FirefoxOptions o = new FirefoxOptions();
	
	}

}
