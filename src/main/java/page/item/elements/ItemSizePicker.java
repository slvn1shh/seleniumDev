package page.item.elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface ItemSizePicker extends ExtendedWebElement<ItemSizePicker> {
    @FindBy(".//span[@class='a-dropdown-prompt'][contains(text(),'Select')]")
    HtmlElement itemSizeSelector();

}
