import net.lightbody.bmp.proxy.ProxyServer;

import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SimpleTest {

    @Test
    public void bmpTest() throws Exception {
        // запуск прокси сервера
        ProxyServer server = new ProxyServer(5555);
        //server.autoBasicAuthorization("example.com", "username", "password");
        server.start();

        // получение Selenium proxy
        Proxy proxy = server.seleniumProxy();

        // конфигурация FirefoxDriver для использования прокси
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver driver = new ChromeDriver();


        // открытие страницы
        driver.get("http://example.com/index");

        // здесь основная часть теста

        driver.quit();
        server.stop();
    }
}