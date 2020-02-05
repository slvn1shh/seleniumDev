package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCart {
    WebDriver driver;

    By subTotalItemsCount = By.id("sc-subtotal-label-activecart");
    By subTotalPrice = By.id("sc-subtotal-amount-activecart");


    public AmazonCart(WebDriver driver){
        this.driver = driver;
    }

    public String getSubtotalItemsCount(){
        return driver.findElement(subTotalItemsCount).getText();
    }
    public String getSubtotalPrice(){
        return driver.findElement(subTotalPrice).getText();
    }
}
