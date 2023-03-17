package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GitHubWelcomePage {

    public SelenideElement searchInput = $(By.name("q"));

}
