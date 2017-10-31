import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverTest {

    @Test
    public void basicTest(){

        System.setProperty("webdriver.chrome.driver","C:\\Dev\\chromedriver_win32\\chromedriver.exe");
        WebDriver chromeDriver =new ChromeDriver();
        String baseUrl = "https://www.google.com";
        chromeDriver.get(baseUrl);
    }

}
