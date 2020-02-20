package steps;

import org.openqa.selenium.By;
import page.item.AmazonItem;
import runner.BaseSteps;
import runner.DriverManager;

import static org.testng.Assert.assertEquals;
import static runner.matchers.MatcherManager.hasText;
import static runner.matchers.MatcherManager.isScriptExecuted;

public class AmazonItemSteps extends BaseSteps {
    private static String resultItemPrice;
    public AmazonItemSteps(DriverManager driver) {
        super(driver);
    }

    public static String getResultItemPrice() {
        return resultItemPrice;
    }

    public AmazonItemSteps selectItemSize(){
        if (onPage().itemSizeContainer().findElements(By.xpath("//div[@id='fitZone_feature_div']")).size() > 0) {
            onPage().itemSizeContainer().itemSizeSelector().click();
            onPage().dropdownSizeItem().click();
            onPage().sizeScriptDoneCondition().waitUntil(isScriptExecuted());
        }
        return this;
    }
    public AmazonItemSteps addItemToCart(){
        if (onPage().findElements(By.xpath("//a[@id='buybox-see-all-buying-choices-announce']")).size() > 0) {
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
    public AmazonCartSteps navigateToCart(){
        if (onPage().findElements(By.xpath("//div[@id='attach-added-to-cart-message']")).size() > 0) {
            onPage().sidesheetContainer().linkToCart().click();
        } else onPage().linkToCart().click();
        return new AmazonCartSteps(getDriverManager());
    }

    private AmazonItem onPage(){
        return on(AmazonItem.class);
    }
}
