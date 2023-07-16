package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLoginPage {

    WebDriver driver;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void amazonLoginWithCredential() {
        WebElement singInBtn = driver.findElement(By.xpath("//a[@data-nav-ref='nav_custrec_signin']"));
        singInBtn.isDisplayed();
        singInBtn.click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("jaishjyoti56@gmail.com");
        driver.findElement(By.xpath("//span[@id='continue']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Jyoti@09876");
        WebElement signSubmitBtn = driver.findElement(By.id("signInSubmit"));
        signSubmitBtn.isDisplayed();
        signSubmitBtn.click();
    }
}
