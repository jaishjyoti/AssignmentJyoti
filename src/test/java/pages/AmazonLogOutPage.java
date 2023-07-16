package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonLogOutPage {
    WebDriver driver;

    public AmazonLogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Account & Lists']"))).perform();
        Thread.sleep(2000);
        WebElement singOutBtn = driver.findElement(By.xpath("//*[text()='Sign Out']"));
        singOutBtn.isDisplayed();
        singOutBtn.click();
    }
}
