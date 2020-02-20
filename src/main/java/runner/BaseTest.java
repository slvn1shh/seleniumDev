package runner;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManager {
    protected DriverManager drvMgr;

    private ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
    private ThreadLocal<BaseSteps> steps = new ThreadLocal<>();

    protected BaseSteps getActions(){
        return steps.get();
    }

    @BeforeMethod
    public void beforeMethod(){
        driverManager.set(new DriverManager());
        driverManager.get().createDriver("chrome");
        steps.set(new BaseSteps(driverManager.get()));
    }

    @AfterMethod
    public void cleanUp() {
        driverManager.get().stopDriver();
    }

    protected <T extends WebPage> T onPage(Class<T> pageClass) {
        return new WebPageFactory().get(drvMgr.getDriver(), pageClass);
    }
}
