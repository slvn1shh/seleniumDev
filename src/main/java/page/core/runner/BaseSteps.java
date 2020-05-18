package page.core.runner;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import steps.AmazonCartSteps;
import steps.AmazonItemSteps;
import steps.AmazonUISteps;

public class BaseSteps {
    private DriverManager driverManager;

    public BaseSteps(DriverManager driver) {
        this.driverManager = driver;
    }

    public AmazonUISteps openMainPage() {
        driverManager.getDriver().navigate().to("https://amazon.com");
        return new AmazonUISteps(driverManager);
    }
    public AmazonItemSteps itemActions(){
        return new AmazonItemSteps(driverManager);
    }

    public AmazonCartSteps proceedWithCart(){
        return new AmazonCartSteps(driverManager);
    }

    protected <X extends WebPage> X on(Class<X> pageClass) {
        return new WebPageFactory().get(driverManager.getDriver(), pageClass);
    }

    protected DriverManager getDriverManager() {
        return driverManager;
    }
}
