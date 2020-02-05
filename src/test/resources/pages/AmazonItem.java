package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.Helper;

public class AmazonItem {
    WebDriver driver;
    Helper helper;
    AmazonUI amUI;

    By sizeDropDown = By.xpath("//span[@class='a-dropdown-prompt'][contains(text(),'Select')]");
    By sizeScriptDoneCondition = By.xpath("//div[@id='unifiedPrice_feature_div' and not(@class='feature js-feature-refresh-overlay')]");
    By searchResultPrice = By.id("priceblock_ourprice");
    By itemSizeSelector = By.xpath("//span[@class='a-dropdown-prompt'][contains(text(),'Select')]");
    By dropdownSizeItem = By.xpath("//li[@id='size_name_0']");
    By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    By sideSheetLink = By.id("attach-close_sideSheet-link"); //this element could appear after adding an item to cart
    By cartItemsCount = By.id("nav-cart-count");

    public AmazonItem(WebDriver driver){
        this.driver = driver;
        helper = new Helper(driver);
        amUI = new AmazonUI(driver);
    }

    public By getSizeScriptDoneCondition() {
        return sizeScriptDoneCondition;
    }
    public String getItemPrice() {
        return driver.findElement(searchResultPrice).getText();
    }
    public By getSizeDropDown() {
        return sizeDropDown;
    }
    public void selectSizeFromDropdown(){
        WebElement sizeDropDown = driver.findElement(itemSizeSelector);
        sizeDropDown.click();
        sizeDropDown.findElement(dropdownSizeItem).click();
        new WebDriverWait(driver, 10).until( // wait for price loading after selecting item size
                ExpectedConditions.visibilityOfElementLocated(getSizeScriptDoneCondition()));
    }
    public void addOneElementToCart(){
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(cartItemsCount)
        );
        driver.findElement(addToCartButton).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBe(cartItemsCount, "1")
        );
    }
    public void gotoCart(){
        if(helper.isElementExistsOnPage(sideSheetLink)){ // this will close covering sidesheet area and allows click on cart button
            driver.findElement(sideSheetLink).click();
        }
        driver.findElement(By.id("nav-cart")).click();
    }

}
