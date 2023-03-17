package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GitHubWelcomePage {

    public SelenideElement searchInput = $x("//*[@name='q']");

}
