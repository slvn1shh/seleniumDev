import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AmazonCart;
import page.AmazonItem;
import page.AmazonSearch;
import page.AmazonUI;
import runner.BaseTest;
import runner.Helper;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AmazonPracticeLogicTest extends BaseTest {
    AmazonUI amUI;
    AmazonItem amItem;
    AmazonCart amCart;
    AmazonSearch amSearch;
    Helper helper;

    @DataProvider(name = "data1")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"puzzle"}, {"socks"}, {"robe"}};
    }

    @BeforeClass
    public void getReady(){
        amUI = new AmazonUI(driver);
        amItem = new AmazonItem(driver);
        amCart = new AmazonCart(driver);
        amSearch = new AmazonSearch(driver);
        helper = new Helper(driver);
    }

    @Test(dataProvider = "data1")
    public void defaultWorkflow(String query) {
        driver.get("https://amazon.com");

        amUI.selectBabySearchCategory();
        amUI.performSearch(query);

        assertThat("Titles is different!", driver.getTitle(), containsString(query));

        // this fails tests ~ in 70% cases because of search word matching (eg socks to panties)
        /*List<WebElement> searchResults = amSearch.getSearchResults(query);
        for(WebElement element : searchResults){
            assertTrue(element.getText().toLowerCase().contains(query), "Amazon results are not matches to your query!");
        }*/

        amSearch.openFirstFoundItem();

        if (helper.isElementExistsOnPage(amItem.getSizeDropDown())) {
            amItem.selectSizeFromDropdown();
        }

        String resultItemPrice = amItem.getItemPrice();

        amItem.addOneElementToCart();
        amItem.gotoCart();

        assertTrue(amCart.getSubtotalItemsCount().contains("1"));
        assertEquals(resultItemPrice, amCart.getSubtotalPrice());
    }

}
