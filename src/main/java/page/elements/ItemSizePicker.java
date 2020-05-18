package page.elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface ItemSizePicker extends ExtendedWebElement<ItemSizePicker> {
    @FindBy(".//span[@id='dropdown_selected_size_name']")
    HtmlElement itemSizeSelector();

}
