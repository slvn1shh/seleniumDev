package runner;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest extends DriverManager{
    protected DriverManager drvMgr;
    protected WebDriver driver;
    protected Helper helper;

    @BeforeTest
    public void setUp() {
        drvMgr = new DriverManager();
        drvMgr.createDriver("chrome");
        this.driver = drvMgr.getDriver();
    }

    @BeforeClass
    public void getReady() {
        helper = new Helper(driver);
    }

    @AfterMethod
    public void cleanUp() {
        drvMgr.getDriver().manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        drvMgr.stopDriver();
    }

    protected  <T extends WebPage> T onPage(Class<T> pageClass){
        return new WebPageFactory().get(drvMgr.getDriver(), pageClass);
    }
}
