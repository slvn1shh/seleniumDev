package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
