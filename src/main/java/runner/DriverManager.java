package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.Arrays.deepToString;

public class DriverManager {
    private WebDriver driver;

    void createDriver(String... driverType) {
        String desiredPlatform = deepToString(driverType);
        switch (desiredPlatform) {

            case "[ff]":
                driver = new FirefoxDriver();
                break;

            case "[chrome]":
            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    void stopDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
