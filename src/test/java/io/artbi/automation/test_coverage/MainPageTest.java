package io.artbi.automation.test_coverage;

import io.artbi.automation.test_coverage.pages.GitHubRepoPage;
import io.artbi.automation.test_coverage.pages.GitHubSearchingResultsPage;
import io.artbi.automation.test_coverage.pages.GitHubWelcomePage;
import io.artbi.automation.test_coverage.steps.GitHubUser;
import io.artbi.automation.test_coverage.steps.UserOnRepositoryPage;
import io.artbi.automation.test_coverage.steps.UserOnResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Execution(ExecutionMode.CONCURRENT)
public class MainPageTest extends BaseTest {
    private final GitHubWelcomePage welcomePage = new GitHubWelcomePage();
    private final GitHubSearchingResultsPage searchingResultsPage = new GitHubSearchingResultsPage();
    private final GitHubRepoPage repoPage = new GitHubRepoPage();

    private final GitHubUser gitHubUser = new GitHubUser();
    private final UserOnResultsPage userOnResultsPage = new UserOnResultsPage();
    private final UserOnRepositoryPage userOnRepositoryPage = new UserOnRepositoryPage();


    @Test
    @Feature("Searching on welcome page")
    @Description("Search test for new user using Step Object")
    public void searching_test_for_new_user_StepObject() {
        gitHubUser.openGitHub()
                .search("Selenide");

        userOnResultsPage.expectsNumberOfResultsShouldBe(10)
                .expectsResultHasText(0, "Concise UI Tests with Java!")
                .followsRepoLink(0);

        userOnRepositoryPage.expectsTitleIs("GitHub - selenide/selenide: Concise UI Tests with Java!");
    }

    @Test
    @Feature("Searching on welcome page")
    @Description("Search test for new user using Page Object")
    public void searching_test_for_new_user_PageObject() {
        open("/");
        step("User type 'Selenide' to the search field and press enter", () -> {
            welcomePage.searchInput
                    .setValue("Selenide")
                    .pressEnter();
        });
        step("Page with results has list of 10 repos ", () -> {
            searchingResultsPage.results.shouldHave(size(10));
        });

        step("The first repo has tittle 'Concise UI Tests with Java!'", () -> {
            searchingResultsPage.results
                    .first().shouldHave(text("Concise UI Tests with Java!"));
        });

        step("User open the first repo", () -> {
            searchingResultsPage.resultLink(0).click();
        });

        step("The page title should be 'GitHub - selenide/selenide: Concise UI Tests with Java!'", () -> {
            repoPage.waitUntilTitleWillBe("GitHub - selenide/selenide: Concise UI Tests with Java!");
        });


    }


}


