package page.general;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import page.general.elements.DropOptions;

public interface AmazonUI extends WebPage {
    @FindBy("//select[@id='searchDropdownBox']")
    DropOptions searchDropdownBox();

    @FindBy("//input[@id='twotabsearchtextbox']")
    HtmlElement searchBox();

}
