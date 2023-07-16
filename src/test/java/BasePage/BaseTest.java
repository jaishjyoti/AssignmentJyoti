package BasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public TestSessionInitiator test;

    @BeforeClass
    public void startSession() {
        test = new TestSessionInitiator();
        test.launchBrowser();
    }
    @AfterClass
    public void closeBrowser() {
        test.closeBrowser();
    }
}
