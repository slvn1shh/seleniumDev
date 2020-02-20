package steps;

import org.openqa.selenium.By;
import page.AmazonItem;
import page.core.runner.BaseSteps;
import page.core.runner.DriverManager;

import static org.testng.Assert.assertEquals;
import static page.core.runner.matchers.MatcherManager.hasText;
import static page.core.runner.matchers.MatcherManager.isScriptExecuted;

public class AmazonItemSteps extends BaseSteps {
    private static String resultItemPrice = "0";
    private By itemSizeContainer = By.xpath("//div[@id='fitZone_feature_div']"); // use to ensure that item have size picker
    private By buyBox = By.xpath("//a[@id='buybox-see-all-buying-choices-announce']"); // use to ensure that item is available from sellers; otherwise use alternative way
    private By sidesheetContainer = By.xpath("//div[@id='attach-added-to-cart-message']"); // use to know which type of popup is appeared after adding item to the cart

    AmazonItemSteps(DriverManager driver) {
        super(driver);
    }

    static String getResultItemPrice() {
        return resultItemPrice;
    }

    public AmazonItemSteps selectItemSize() {
        if (onPage().itemSizeContainer().findElements(itemSizeContainer).size() > 0) {
            onPage().itemSizeContainer().itemSizeSelector().click();
            onPage().dropdownSizeItem().click();
            onPage().sizeScriptDoneCondition().waitUntil(isScriptExecuted());
        }
        return this;
    }

    public AmazonItemSteps addItemToCart() {
        if (onPage().findElements(buyBox).size() > 0) {
            onPage().linkToOtherSellers().click();
            resultItemPrice = onPage().itemPriceOfferListing().getText();
            onPage().addToCartOfferListing().click();
        } else {
            resultItemPrice = onPage().searchResultPrice().getText();
            onPage().addToCartButton().click();
        }

        assertEquals(onPage().cartItemsCount().waitUntil(hasText("1")).getText(), "1");
        return this;
    }

    public AmazonCartSteps navigateToCart() {
        if (onPage().findElements(sidesheetContainer).size() > 0) {
            onPage().sidesheetContainer().linkToCart().click();
        } else onPage().linkToCart().click();
        return new AmazonCartSteps(getDriverManager());
    }

    private AmazonItem onPage() {
        return on(AmazonItem.class);
    }
}
