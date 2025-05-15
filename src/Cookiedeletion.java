import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Cookiedeletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("Pass the Cookie name which u wanted to delete");
			
		
	}

}
