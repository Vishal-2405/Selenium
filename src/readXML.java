import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
public class readXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new ChromeDriver();

	        // Load local XML file in browser
	        File file = new File("PosLog.xml");
	        String fileUrl = "file:///" + file.getAbsolutePath().replace("\\", "/");
	        driver.get(fileUrl);

	        // === Extract <ItemID> values ===
	        List<WebElement> itemIds = driver.findElements(By.xpath("//*[local-name()='ItemID']"));
	        System.out.println("ItemIDs:");
	        for (WebElement item : itemIds) {
	            System.out.println(item.getText());
	        }
	        // === Extract <Description> values ===
	        List<WebElement> descriptions = driver.findElements(By.xpath("//*[local-name()='Description']"));
	        System.out.println("\nDescriptions:");
	        for (WebElement desc : descriptions) {
	            System.out.println(desc.getText());
	        }

	        // === Extract <Amount> from <Tax> ===
	        List<WebElement> amounts = driver.findElements(By.xpath("//*[local-name()='Tax']/*[local-name()='Amount']"));
	        System.out.println("\nTax Amounts:");
	        for (WebElement amt : amounts) {
	            System.out.println(amt.getText());
	        }

	        // Close browser
//	        driver.quit();
		
	}

}
