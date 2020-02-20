package page.core.runner.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

class IsDisplayedMatcher extends TypeSafeMatcher<WebElement> {
    private int timeout = 10;

    private IsDisplayedMatcher() {
    }

    private IsDisplayedMatcher(int timeout) {
        this.timeout = timeout;
    }

    @Factory
    static Matcher<WebElement> isDisplayed() {
        return new IsDisplayedMatcher();
    }

    @Factory
    static Matcher<WebElement> isDisplayed(int timeout) {
        return new IsDisplayedMatcher(timeout);
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        long waitUntil = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeout);
        boolean isDisplayed = false;
        while (System.currentTimeMillis() <= waitUntil && !isDisplayed) {
            try {
                Thread.sleep(250);
                isDisplayed = item.isDisplayed();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("element is displayed on pageName");
    }

}
