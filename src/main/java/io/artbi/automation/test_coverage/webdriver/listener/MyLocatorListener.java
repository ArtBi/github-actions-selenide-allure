package io.artbi.automation.test_coverage.webdriver.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class MyLocatorListener implements BaseWebDriverListener {

    private final List<Locator> locators;

    public MyLocatorListener() {
        this.locators = new ArrayList<>();
    }

    @Override
    public void afterClickOn(final WebElement element,
                             final WebDriver driver) {
        getLocator(element).ifPresent(locator -> {
            locator.getUrls().add(driver.getCurrentUrl());
            locator.setAction("Click on");
            locators.add(locator);
            System.out.printf("Clicked on -> %s%n", locator.getFullPath());
        });
    }

    @Override
    public void afterChangeValueOf(final WebElement element,
                                   final WebDriver driver,
                                   final CharSequence[] keysToSend) {
        getLocator(element).ifPresent(locator -> {
            locator.getUrls().add(driver.getCurrentUrl());
            locator.setAction("Set Value");
            locators.add(locator);
            System.out.printf("Set Value %s for -> %s%n", Arrays.toString(keysToSend), locator.getFullPath());
        });
    }

    public void addAttachment() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final String content = mapper.writeValueAsString(locators);
        Allure.attachment("locators2", content);
    }

    private Optional<Locator> getLocator(final WebElement element) {
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");
        String type = pathVariables[0].trim();
        String value = pathVariables[1].trim();
        switch (type) {
            case "xpath":
                return Optional.of(new Locator().setType(type).setFullPath(value));
            default:
                return Optional.empty();
        }
    }
}
