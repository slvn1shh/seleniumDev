package runner;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;

public class BaseSteps {
    DriverManager driverManager;

    public BaseSteps(DriverManager driver) {
        this.driverManager = driver;
    }

    protected <X extends WebPage> X on(Class<X> pageClass) {
        return new WebPageFactory().get(driverManager.getDriver(), pageClass);
    }

    protected DriverManager getDriverManager() {
        return driverManager;
    }

}
