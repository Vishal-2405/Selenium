import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Base {

	public static void main(String[] args) {
//Chromedriver.exe is responsible to invoking the browser
		System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/chromedriver.exe");
//Step -1 Invoking the browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());

		
		

	}

}
