package page.elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface DropOptions extends ExtendedWebElement<DropOptions> {
    @FindBy(".//option[contains(text(),'Baby')]")
    HtmlElement babySearchCategory();
}
