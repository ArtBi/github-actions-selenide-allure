package io.artbi.automation.test_coverage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.artbi.automation.test_coverage.webdriver.listener.MyLocatorListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private MyLocatorListener locatorsListener;

    @BeforeAll
    public static void setUpAll() {
        Configuration.baseUrl = "https://github.com";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = Configuration.browserCapabilities.merge(capabilities);
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open();
        WebDriver driver = WebDriverRunner.getWebDriver();

        final EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        locatorsListener = new MyLocatorListener();
        eventFiringWebDriver.register(locatorsListener);
        WebDriverRunner.setWebDriver(eventFiringWebDriver);
    }

    @AfterEach
    public void stopDriver() throws IOException {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().quit();
            locatorsListener.addAttachment();
        }
    }
}
