package page;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import page.elements.DropOptions;

public interface AmazonUI extends BasePage {
    @FindBy("//select[@id='searchDropdownBox']")
    DropOptions searchDropdownBox();

    @FindBy("//input[@id='twotabsearchtextbox']")
    HtmlElement searchBox();

}
