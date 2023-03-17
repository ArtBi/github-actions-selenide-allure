package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class GitHubRepoPage {

    public void waitUntilTitleWillBe(String title) {
        Selenide.Wait().until(titleIs(title));
    }

}
