package runner;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import page.AmazonCart;
import page.AmazonItem;
import page.AmazonUI;

public class BaseTest {
    protected WebDriver driver;
    protected AmazonUI amUI;
    protected AmazonItem amItem;
    protected AmazonCart amCart;
    protected Helper helper;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void getReady() {

        amUI = new AmazonUI(driver);
        amItem = new AmazonItem(driver);
        amCart = new AmazonCart(driver);
        helper = new Helper(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    public <T extends WebPage> T on(Class<T> pageClass){
        return new WebPageFactory().get(driver, pageClass);
    }
}
