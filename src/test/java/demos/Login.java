package demos;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    @Test
    public void loginTest() {

        String browserType = "chrome";
        WebDriver driver;

        driver = utilities.DriverFactory.open(browserType);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx?");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$MainContent$btnLogin")));

        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(("tim@testemail.com"));
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(("trpass"));
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("CONFIRMATION : " + message);

        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE : " + pageTitle);

//        driver.close();
    }
}