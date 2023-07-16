package tests;

import BasePage.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonFunctionalityTest extends BaseTest {
    @Test
    public void amazonLoginWithCredential() {
        test.amazonLoginPage.amazonLoginWithCredential();
    }
    @Test(dependsOnMethods = "amazonLoginWithCredential")
    public void amazonTestClass() throws InterruptedException {
        test.amazonHomePage.searchProducts("mac laptop");
        test.amazonHomePage.printAllTheProducts();
        String actualItemAddedToCat = test.amazonHomePage.addProductToCart();
        Assert.assertEquals(actualItemAddedToCat, "Added to Cart");
        boolean updatedSubTotalItems = test.amazonHomePage.updateProduct();
        Assert.assertTrue(updatedSubTotalItems);
        String actualMsgAfterDeletion = test.amazonHomePage.deleteTheProduct();
        Assert.assertEquals(actualMsgAfterDeletion, "Your Amazon Cart is empty.");
        test.logOutPage.logOut();
    }
}
