package page.core.runner.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

class LoadScriptExecutedMatcher extends TypeSafeMatcher<WebElement> {

    private LoadScriptExecutedMatcher() {

    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        int timeout = 10;
        long waitUntil = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeout);
        boolean isExecuted = false;
        while (System.currentTimeMillis() <= waitUntil && !isExecuted) {
            try {
                Thread.sleep(250);
                isExecuted = !item.getAttribute("class").equals("feature js-feature-refresh-overlay");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return isExecuted;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("this waits for script at item page to be executed");
    }

    @Factory
    static Matcher<WebElement> isExecuted() { return new LoadScriptExecutedMatcher();}
}
