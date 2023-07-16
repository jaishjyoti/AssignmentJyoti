package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonLogOutPage;

public class TestSessionInitiator {
    WebDriver driver;
    public AmazonLoginPage amazonLoginPage;
    public AmazonHomePage amazonHomePage;
    public AmazonLogOutPage logOutPage;

    private void initPage() {
        amazonLoginPage = new AmazonLoginPage(driver);
        amazonHomePage = new AmazonHomePage(driver);
        logOutPage = new AmazonLogOutPage(driver);
    }
    public void launchBrowser() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src\\test\\resource\\driver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        this.initPage();
    }
    public void closeBrowser() {
        driver.quit();
    }
}
