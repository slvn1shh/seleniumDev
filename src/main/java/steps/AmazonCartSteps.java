package steps;

import page.AmazonCart;
import page.core.runner.BaseSteps;
import page.core.runner.DriverManager;

import static org.testng.Assert.*;

public class AmazonCartSteps extends BaseSteps {

    AmazonCartSteps(DriverManager driver) {
        super(driver);
    }
    public AmazonCartSteps verifyItemInCart(){
        assertTrue(onPage().subTotalItemsCount().getText().contains("1"));
        if(!AmazonItemSteps.getResultItemPrice().equals("0"))
            assertEquals(AmazonItemSteps.getResultItemPrice(), onPage().subTotalPrice().getText());
        else fail();
        return this;
    }
    private AmazonCart onPage(){
        return on(AmazonCart.class);
    }
}
