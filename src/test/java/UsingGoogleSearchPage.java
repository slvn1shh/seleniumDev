import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingGoogleSearchPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");

        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        page.searchFor("Cheese");
    }
}
