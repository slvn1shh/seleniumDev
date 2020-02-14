package page.cart;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface AmazonCart extends WebPage {
    @FindBy("//span[@id='sc-subtotal-label-activecart']")
    HtmlElement subTotalItemsCount();

    @FindBy("//span[@id='sc-subtotal-amount-activecart']")
    HtmlElement subTotalPrice();
}
