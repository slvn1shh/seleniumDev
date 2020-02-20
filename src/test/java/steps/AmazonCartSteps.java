package steps;

import page.cart.AmazonCart;
import runner.BaseSteps;
import runner.DriverManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AmazonCartSteps extends BaseSteps {

    AmazonCartSteps(DriverManager driver) {
        super(driver);
    }
    public AmazonCartSteps verifyItemInCart(){
        assertTrue(onPage().subTotalItemsCount().getText().contains("1"));
        assertEquals(AmazonItemSteps.getResultItemPrice(), onPage().subTotalPrice().getText());
        return this;
    }
    private AmazonCart onPage(){
        return on(AmazonCart.class);
    }
}
