package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory{

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_LOCATION = "C:\\Dev\\chromedriver_win32\\chromedriver.exe";
    private static final String GEKHO_DRIVER = "webdriver.gecko.driver";
    private static final String GEKHO_DRIVER_LOCATION = "C:\\dev\\geckodriver-v0.16.1-win64\\geckodriver.exe";

    public static WebDriver open(String browserType){

        if (browserType.equals("firefox")) {
            System.setProperty(GEKHO_DRIVER, GEKHO_DRIVER_LOCATION);
            System.out.println("using firefox - geckho driver");
            return new FirefoxDriver();
        } else {
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_LOCATION);
            System.out.println("using chrome - driver");
            return new ChromeDriver();
        }
    }
}
