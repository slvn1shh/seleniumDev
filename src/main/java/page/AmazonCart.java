package page;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import page.BasePage;

public interface AmazonCart extends BasePage {
    @FindBy("//span[@id='sc-subtotal-label-activecart']")
    HtmlElement subTotalItemsCount();

    @FindBy("//span[@id='sc-subtotal-amount-activecart']")
    HtmlElement subTotalPrice();
}
