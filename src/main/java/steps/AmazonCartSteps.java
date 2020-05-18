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
        assertTrue(onPage().itemTitle().getText().contains(productName.substring(0,10)));
        assertTrue(onPage().subTotalItemsCount().getText().contains("1"));
        if(!resultItemPrice.equals("0"))
            assertEquals(resultItemPrice, onPage().subTotalPrice().getText().replace('\n', '.'));
        else fail("The price of the goods is zero! Have you added something to the cart?");
    }
    private AmazonCart onPage(){
        return on(AmazonCart.class);
    }
}
