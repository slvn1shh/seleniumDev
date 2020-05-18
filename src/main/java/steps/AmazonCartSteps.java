package steps;

import page.AmazonCart;
import page.core.runner.BaseSteps;
import page.core.runner.DriverManager;

import static org.testng.Assert.*;

public class AmazonCartSteps extends BaseSteps {

    public AmazonCartSteps(DriverManager driver) {
        super(driver);
    }
    public void verifyItemInCart(String resultItemPrice, String productName){
        assertTrue(onPage().itemTitle().getText().contains(productName));
        assertTrue(onPage().subTotalItemsCount().getText().contains("1"));
        if(!resultItemPrice.equals("0"))
            assertTrue(onPage().subTotalPrice().getText().contains(resultItemPrice));
        else fail();
    }
    private AmazonCart onPage(){
        return on(AmazonCart.class);
    }
}
