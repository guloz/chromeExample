package demos;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

    @Test
    public void main() {

        String name = "Mary Smith";
        String email = "ms@testemail.com";
        String password = "mypass";
        String phoneNumber = "123123123";
        String country = "Germany";
        String browserType = "chrome";
        WebDriver driver;

        String gender = "Male";

        Boolean weeklyEmail = true;
        Boolean monthlyEmail = true;
        Boolean occasionalEmail = false;


        driver = utilities.DriverFactory.open(browserType);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx?");
        driver.findElement(By.xpath("id(\"ctl01\")/div[3]/div[2]/div[1]/div[2]/a[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$MainContent$txtFirstName")));

        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
        WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
        WebElement monthlyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail"));
        WebElement occasionalCheckbox = driver.findElement(By.name("ctl00$MainContent$checkUpdates"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        countryElement.sendKeys("Germany");


        if (gender.equalsIgnoreCase("Male")) {
            maleRadio.click();
        } else {
            femaleRadio.click();
        }

        if (weeklyEmail == true) {
            if (!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        } else {
            if (weeklyCheckbox.isSelected()) {
                System.out.println("Weekly Check box already selected, dont click");
            }
        }

        if (monthlyEmail == true) {
            if (!monthlyCheckbox.isSelected()) {
                monthlyCheckbox.click();
            }
        } else {
            if (monthlyCheckbox.isSelected()) {
                System.out.println("Monthly Check box already selected, dont click");
            }
        }

        if (occasionalEmail == true) {
            if (!occasionalCheckbox.isSelected()) {
                System.out.println("Occasional updates Check box is not selected, dont click");
            }
        } else {
            if (occasionalCheckbox.isSelected()) {
                occasionalCheckbox.click();
                System.out.println("Unticked the occasional update button");
            }
        }

        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);

        submitButton.click();

        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION:" + conf);
        String expectedMessage = "Customer information added successfully";

        if (expectedMessage.equalsIgnoreCase(conf)) {
            System.out.print("CONFIRMATION : " + conf);
        } else {
            System.out.print("FAILED");
        }
    }

}
