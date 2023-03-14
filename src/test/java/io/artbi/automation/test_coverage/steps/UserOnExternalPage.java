package io.artbi.automation.test_coverage.steps;

import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class UserOnExternalPage {

    public UserOnExternalPage expectsTitle(String title) {
        Selenide.Wait().until(titleIs(title));
        return this;
    }
}
