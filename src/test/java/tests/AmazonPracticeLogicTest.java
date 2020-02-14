package tests;

import io.qameta.htmlelements.matcher.HasTextMatcher;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.cart.AmazonCart;
import page.general.AmazonUI;
import page.item.AmazonItem;
import page.search.AmazonSearch;
import runner.BaseTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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


//        if(onPage(AmazonItem.class).itemSizeSelector().isDisplayed()){
//            onPage(AmazonItem.class).itemSizeSelector().click();
//            onPage(AmazonItem.class).dropdownSizeItem().click();
//            onPage(AmazonItem.class).sizeScriptDoneCondition().waitUntil(Predicate.not(WebElement::isDisplayed));
//        }

        String resultItemPrice = onPage(AmazonItem.class).searchResultPrice().getText();

        onPage(AmazonItem.class).addToCartButton().click();
        try {
            onPage(AmazonItem.class).cartItemsCount().waitUntil(HasTextMatcher.hasText(onPage(AmazonItem.class).cartItemsCount().getText()));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        assertEquals(onPage(AmazonItem.class).cartItemsCount().getText(), "1");

        if(onPage(AmazonItem.class).sideSheetLinkToCart().isDisplayed()){
            onPage(AmazonItem.class).sideSheetLinkToCart().click();
        } else onPage(AmazonItem.class).linkToCart().click();

        assertTrue(onPage(AmazonCart.class).subTotalItemsCount().getText().contains("1"));
        assertEquals(resultItemPrice, onPage(AmazonCart.class).subTotalPrice().getText());
    }

}
