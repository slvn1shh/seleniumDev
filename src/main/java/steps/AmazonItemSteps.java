package steps;

import page.AmazonItem;
import page.core.runner.BaseSteps;
import page.core.runner.DriverManager;

import static page.core.runner.matchers.MatcherManager.*;

public class AmazonItemSteps extends BaseSteps {

    public AmazonItemSteps(DriverManager driver) {
        super(driver);
    }

    public void selectItemSize() {
        if (onPage().itemSizeContainerZone().size() > 0) {
            onPage().itemSizeContainer().itemSizeSelector().click();
            onPage().dropdownSizeItem().click();
            onPage().sizeScriptDoneCondition().waitUntil(isScriptExecuted());
        }
    }

    public String getItemPrice() {
        if (onPage().buyBox().size() > 0) {
            onPage().linkToOtherSellers().click();
            return onPage().itemPriceOfferListing().getText();
        } else return onPage().searchResultPrice().getText();
    }

    public String getProductName(){
        return onPage().productTitle().getText();
    }

    public AmazonItemSteps addItemToCart(){
        if (onPage().buyBox().size() > 0) {
            onPage().addToCartOfferListing().click();
        } else {
            onPage().addToCartButton().click();
        }

//        assertEquals(onPage().cartItemsCount().waitUntil(hasText("1")).getText(), "1");
        return this;
    }

    public AmazonCartSteps navigateToCart() {
        if (onPage().sidesheetContainerCart().size() > 0) {
            onPage().sidesheetContainer().linkToCart().click();
        } else onPage().linkToCart().click();
        return new AmazonCartSteps(getDriverManager());
    }

    private AmazonItem onPage() {
        return on(AmazonItem.class);
    }
}
