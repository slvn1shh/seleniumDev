package page;

import runner.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonUI {
    WebDriver driver;
    Helper helper;

    By searchDropdownBox = By.xpath("//select[@id='searchDropdownBox']");
    By babyDropOption = By.xpath("//option[contains(text(),'Baby')]");
    By searchTextBox = By.id("twotabsearchtextbox");
    By goToCartButton = By.id("nav-cart");
    By cartItemsCount = By.id("nav-cart-count");


    public AmazonUI(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    public void performSearch(String query) {
        WebElement searchField = driver.findElement(searchTextBox);
        searchField.sendKeys(query);
        searchField.submit();
    }

    public void selectBabySearchCategory() { // of course, this should be template with parameter
        driver.findElement(searchDropdownBox).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'Baby')]"))
        );
        driver.findElement(babyDropOption).click();
    }
}
