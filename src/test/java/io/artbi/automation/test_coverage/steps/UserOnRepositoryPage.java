package io.artbi.automation.test_coverage.steps;

import io.artbi.automation.test_coverage.pages.GitHubRepoPage;
import io.qameta.allure.Step;

public class UserOnRepositoryPage {

    GitHubRepoPage repoPage = new GitHubRepoPage();

    @Step("Page title should be {0}")
    public UserOnRepositoryPage expectsTitleIs(String title) {
        repoPage.waitUntilTitleWillBe(title);
        return this;
    }
}
