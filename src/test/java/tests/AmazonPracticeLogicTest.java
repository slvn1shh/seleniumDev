package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AmazonCart;
import page.AmazonUI;
import page.AmazonItem;
import page.AmazonSearch;
import runner.BaseTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static runner.matchers.MatcherManager.hasText;
import static runner.matchers.MatcherManager.isScriptExecuted;

public class AmazonPracticeLogicTest extends BaseTest {

    @DataProvider(name = "data1")
    public Object[] dataProviderMethod() {
        return new Object[]{"puzzle", "socks", "robe"};
    }

    @Test(dataProvider = "data1")
    public void defaultWorkflow(String query) {
        drvMgr.getDriver().get("https://amazon.com");

        onPage(AmazonUI.class).searchDropdownBox().babySearchCategory().click();
        onPage(AmazonUI.class).searchBox().sendKeys(query);
        onPage(AmazonUI.class).searchBox().submit();

        assertThat("Titles is different!", drvMgr.getDriver().getTitle(), containsString(query));

        onPage(AmazonSearch.class).searchResults().get(0).linkToItem().click();

        if (onPage(AmazonItem.class).itemSizeContainer().findElements(By.xpath("//div[@id='fitZone_feature_div']")).size() > 0) {
            onPage(AmazonItem.class).itemSizeContainer().itemSizeSelector().click();
            onPage(AmazonItem.class).dropdownSizeItem().click();
            onPage(AmazonItem.class).sizeScriptDoneCondition().waitUntil(isScriptExecuted());
        }

        String resultItemPrice;
        if (onPage(AmazonItem.class).findElements(By.xpath("//a[@id='buybox-see-all-buying-choices-announce']")).size() > 0) {
            onPage(AmazonItem.class).linkToOtherSellers().click();
            resultItemPrice = onPage(AmazonItem.class).itemPriceOfferListing().getText();
            onPage(AmazonItem.class).addToCartOfferListing().click();
        } else {
            resultItemPrice = onPage(AmazonItem.class).searchResultPrice().getText();
            onPage(AmazonItem.class).addToCartButton().click();
        }

        assertEquals(onPage(AmazonItem.class).cartItemsCount().waitUntil(hasText("1")).getText(), "1");

        if (onPage(AmazonItem.class).findElements(By.xpath("//div[@id='attach-added-to-cart-message']")).size() > 0) {
            onPage(AmazonItem.class).sidesheetContainer().linkToCart().click();
        } else onPage(AmazonItem.class).linkToCart().click();

        assertTrue(onPage(AmazonCart.class).subTotalItemsCount().getText().contains("1"));
        assertEquals(resultItemPrice, onPage(AmazonCart.class).subTotalPrice().getText());
    }
}