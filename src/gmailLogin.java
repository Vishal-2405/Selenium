

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class gmailLogin {

    public WebDriver driver;
    private WebDriverWait wait;
    private final String USERNAME = "belktestemailauto12@gmail.com";
    private final String PASSWORD = "Train#321";
    private final String TRANS_ID = "9337";

    @Test
    public void Login() throws InterruptedException {
        setupDriver();
        loginToGmail();
        searchTransaction(TRANS_ID);
        extractOrderSummary();
        
    }

    private void setupDriver() {
        ChromeOptions options = new ChromeOptions();
//        This line configures ChromeDriver for Selenium to run in a more stable, maximized, and stealthy mode, minimizing detection and compatibility issues in automated environments.
        options.addArguments("--disable-blink-features=AutomationControlled", "--no-sandbox", "--disable-infobars", "--disable-dev-shm-usage", "--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void loginToGmail() throws InterruptedException {
        driver.get("https://mail.google.com/mail/u/0/#inbox");
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(USERNAME);
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(PASSWORD);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
    }

    private void searchTransaction(String transId) throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search mail']"));
        Thread.sleep(3000);
        searchBar.click();
        Thread.sleep(3000);
        searchBar.sendKeys(transId + Keys.ENTER);
        WebElement firstEmailRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Thanks! We’re preparing your order #')])[16]")));
        Thread.sleep(2000);
        firstEmailRow.click();
    }

    private void extractOrderSummary() throws InterruptedException {
//        To Load the page of email body
    	Thread.sleep(1000);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
//        To view the scroll bar in the email page.
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='75%'");
        WebElement orderSummary = driver.findElement(By.cssSelector("td[height='16'][align='left']"));
        String orderText = orderSummary.getText();
        System.out.println("Order Details: " + orderText);
        System.out.println("-------------------------------");
    }
}