package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import runner.BaseTest;

public class AmazonBaseLogicTest extends BaseTest {

    @DataProvider(name = "searchQueries")
    public Object[] dataProviderMethod() {
        return new Object[]{"puzzle", "socks", "robe"};
    }

    @Test(dataProvider = "searchQueries")
    public void LogicTest(String query){
        getActions().
            openMainPage()
                .selectCategory()
                .performSearch(query)
                .openItemFromSearch()
                .selectItemSize()
                .addItemToCart()
                .navigateToCart()
                .verifyItemInCart();
    }
}
