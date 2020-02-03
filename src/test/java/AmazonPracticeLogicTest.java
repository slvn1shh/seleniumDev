import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AmazonPracticeLogicTest {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

        driver.findElement(By.cssSelector("#searchDropdownBox")).click();
        new WebDriverWait(driver,10).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'Baby')]"))
        );
        driver.findElement(By.xpath("//option[contains(text(),'Baby')]")).click();
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys(query);
        searchField.submit();

        assertThat("Titles is different!", driver.getTitle(), containsString(query));

        List<WebElement> searchResults = driver.findElements(By.xpath("//span[contains(text(),'"+
                StringUtils.capitalize(query) +"')]"));
        for(WebElement element : searchResults){
            assertTrue(element.getText().toLowerCase().contains(query), "Amazon results are not matches to your query!");
        }

        WebElement searchResultItem = driver.findElement(
                By.xpath("//div[@data-index='0']/.//span[contains(text(),'"+ StringUtils.capitalize(query) +"')]"));
        searchResultItem.click();

        if(driver.findElements(By.xpath("//span[@class='a-dropdown-prompt'][contains(text(),'Select')]")).size() > 0){
            WebElement sizeDropDown = driver.findElement(By.
                    xpath("//span[@class='a-dropdown-prompt'][contains(text(),'Select')]"));
            sizeDropDown.click();
            sizeDropDown.findElement(By.xpath("//li[@id='size_name_0']")).click();
            new WebDriverWait(driver, 10).until( // wait for price loading after selecting item size
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[@id='unifiedPrice_feature_div' and not" +
                                    "(@class='feature js-feature-refresh-overlay')]")));
        }

        WebElement searchResultPrice = driver.findElement(By.id("priceblock_ourprice"));
        String resultItemPrice = searchResultPrice.getText();

        driver.findElement(By.name("submit.add-to-cart")).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBe(By.id("nav-cart-count"), "1")
        );

        if(driver.findElements(By.id("attach-close_sideSheet-link")).size() > 0){
            driver.findElement(By.id("attach-close_sideSheet-link")).click();
            driver.findElement(By.id("nav-cart")).click();
        } else{
            driver.findElement(By.cssSelector("#hlb-view-cart-announce")).click();
        }

        WebElement cartSubtotalItem = driver.findElement(By.id("sc-subtotal-label-activecart"));
        WebElement cartSubtotalPrice = driver.findElement(By.id("sc-subtotal-amount-activecart"));

        assertTrue(cartSubtotalItem.getText().contains("1"));
        assertEquals(resultItemPrice, cartSubtotalPrice.getText());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
