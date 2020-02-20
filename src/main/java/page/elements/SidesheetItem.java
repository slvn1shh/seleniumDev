package page.elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface SidesheetItem extends ExtendedWebElement<SidesheetItem> {
    @FindBy(".//span[@id='attach-sidesheet-view-cart-button']")
    HtmlElement linkToCart();
}
