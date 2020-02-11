import io.qameta.htmlelements.WebPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AmazonSearch;
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
        driver.get("https://amazon.com");

        amUI.selectBabySearchCategory();
        amUI.performSearch(query);

        assertThat("Titles is different!", driver.getTitle(), containsString(query));

        onPage(AmazonSearch.class).searchResults().get(0).linkToItem().click();

        if (helper.isElementExistsOnPage(amItem.getSizeDropDown())) {
            amItem.selectSizeFromDropdown();
        }

        String resultItemPrice = amItem.getItemPrice();

        amItem.addOneElementToCart();
        amItem.gotoCart();

        assertTrue(amCart.getSubtotalItemsCount().contains("1"));
        assertEquals(resultItemPrice, amCart.getSubtotalPrice());
    }

    private <T extends WebPage> T onPage(Class<T> pageClass){
        return on(pageClass);
    }
}
