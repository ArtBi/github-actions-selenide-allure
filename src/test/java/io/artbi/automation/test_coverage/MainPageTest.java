package io.artbi.automation.test_coverage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.artbi.automation.test_coverage.webdriver.listener.MyLocatorListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    private MyLocatorListener locatorsListener;
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        final EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        locatorsListener = new MyLocatorListener();
        eventFiringWebDriver.register(locatorsListener);
        WebDriverRunner.setWebDriver(eventFiringWebDriver);
        open(MainPage.URL);
    }

    @Test
    public void search() {
        mainPage.searchField.shouldBe(visible)
                .setValue("werjh");

        ElementsCollection results = mainPage.searchResult.shouldBe(visible)
                .$$x("./li");

        Assertions.assertThat(results).allSatisfy(result -> {
            result.has(text("цукор"));
        });
    }


    @AfterEach
    public void stopDriver() throws IOException {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().close();
            locatorsListener.addAttachment();
        }
    }
}


