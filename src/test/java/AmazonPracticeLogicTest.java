import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AmazonPracticeLogicTest {
    WebDriver driver;
    AmazonUI amUI;
    AmazonItem amItem;
    AmazonCart amCart;
    AmazonSearch amSearch;
    Helpers helper;

    @BeforeTest()
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        amUI = new AmazonUI(driver);
        amItem = new AmazonItem(driver);
        amCart = new AmazonCart(driver);
        amSearch = new AmazonSearch(driver);
        helper = new Helpers(driver);
    }

    @DataProvider(name = "data1")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "puzzle" }, { "socks" }, { "robe" } };
    }

    @BeforeMethod
    public void getReady(){
        driver.manage().deleteAllCookies();
        driver.get("https://amazon.com");
    }

    @Test(dataProvider = "data1")
    public void defaultWorkflow(String query) {
        amUI.selectBabySearchCategory();
        amUI.performSearch(query);

        assertThat("Titles is different!", driver.getTitle(), containsString(query));

        // this fails tests ~ in 70% cases because of search word matching (eg socks to panties)
        /*List<WebElement> searchResults = amSearch.getSearchResults(query);
        for(WebElement element : searchResults){
            assertTrue(element.getText().toLowerCase().contains(query), "Amazon results are not matches to your query!");
        }*/

        amSearch.openFirstFoundItem();

        if(helper.isElementExistsOnPage(amItem.getSizeDropDown())){
            amItem.selectSizeFromDropdown();

        }

        String resultItemPrice = amItem.getItemPrice();

        amItem.addOneElementToCart();
        amItem.gotoCart();

        assertTrue(amCart.getSubtotalItemsCount().contains("1"));
        assertEquals(resultItemPrice, amCart.getSubtotalPrice());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
