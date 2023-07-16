package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class AmazonHomePage {
    WebDriver driver;
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void searchProducts(String searchItem) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.isDisplayed();
        searchBox.sendKeys(searchItem);
        WebElement searchBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        searchBtn.isDisplayed();
        searchBtn.click();
    }
    public void printAllTheProducts() {
        List<WebElement> products = driver.findElements(By.xpath("//h2[contains(@class,'a-size-mini a-spacing-none a-color-base s-line-clamp')]//span"));
        for (WebElement element : products) {
            System.out.println("Searched Item on page: --" + element.getText());
        }
    }
    public String addProductToCart() throws InterruptedException {
        WebElement firstItemOnSearch = driver.findElement(By.xpath("(//h2[contains(@class,'a-size-mini a-spacing-none a-color-base s-line-clamp')]//span)[1]"));
        firstItemOnSearch.isDisplayed();
        firstItemOnSearch.click();
        Set<String> allWindows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement addToCartBtn = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
        addToCartBtn.isDisplayed();
        addToCartBtn.click();
        Thread.sleep(5000);
        String itemAddedToCart = driver.findElement(By.xpath("(//h4[text()='Added to Cart'])[2]")).getText();
        return itemAddedToCart;
    }
    public boolean updateProduct() {
        WebElement viewCartBtn = driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']"));
        viewCartBtn.isDisplayed();
        viewCartBtn.click();
        driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
        String beforeUpdateSubTotalItem = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText();
        driver.findElement(By.xpath("(//a[@class='a-dropdown-link'])[2]")).click();
        String afterUpdatedsubTotalItem = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText();

        if (Integer.parseInt(afterUpdatedsubTotalItem) > Integer.parseInt(beforeUpdateSubTotalItem)) {
            return true;
        }
        return false;
    }
    public String deleteTheProduct() throws InterruptedException {
        Thread.sleep(2000);
        WebElement deleteItemBtn = driver.findElement(By.xpath("//input[@data-action='delete']"));
        deleteItemBtn.isDisplayed();
        deleteItemBtn.click();
        Thread.sleep(3000);
        String afterDeletionItemMsg = driver.findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']")).getText();

        return afterDeletionItemMsg;
    }
}


