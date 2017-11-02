package demos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJunit {

    WebDriver driver;
    String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx?";

    @Test
    public void getPageTitle() {
        String webURL = webUrl;
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(actualTitle, expectedTitle);
//        Assert.fail("We intentionally failed this test");
        tearDown();
    }

    @Before
    public void setUp() {
        System.out.println("OOSetting up the test");
//        System.out.println("initilasing the driver");
        driver = utilities.DriverFactory.open("chrome");
    }

    public void tearDown() {
        System.out.println("Closing the test");
//        System.out.println("Closing the driver");
        driver.close();
    }
}
