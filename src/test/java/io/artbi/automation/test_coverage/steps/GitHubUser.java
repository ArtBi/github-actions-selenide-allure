package io.artbi.automation.test_coverage.steps;

import io.artbi.automation.test_coverage.pages.GitHubWelcomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;


public class GitHubUser {
    private final GitHubWelcomePage github = new GitHubWelcomePage();

    @Step("User open main GitHub page")
    public GitHubUser openGitHub() {
        open("/");
        return this;
    }

    @Step("User search the following text: {0}")
    public UserOnResultsPage search(String text) {
        this.github.searchInput.setValue(text).pressEnter();
        return new UserOnResultsPage();
    }

}
