package io.artbi.automation.test_coverage;

import com.codeborne.selenide.Selenide;
import io.artbi.automation.test_coverage.pages.GitHubWelcomePage;
import io.artbi.automation.test_coverage.steps.GitHubUser;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

@Execution(ExecutionMode.CONCURRENT)
public class MainPageTest extends BaseTest {
    private final GitHubWelcomePage github = new GitHubWelcomePage();


    @Test
    @Feature("Searching on welcome page")
    @Description("Search test for new user using Step Object")
    public void search() {
        new GitHubUser().openGitHub()
                .search("Selenide")
                .expectedNumberOfResults(10)
                .expectedResultWithText(0, "Concise UI Tests with Java!")
                .followRepoLink(0);
    }

    @Test
    @Feature("Searchi on welcome page")
    @Description("Search test for new user using Page Object")
    public void searchPage() {
        open("/");
        step("User type Selenide to the search field and press enter", () -> {
            github.searchInput
                    .setValue("Selenide")
                    .pressEnter();
        });
        step("User open the first repo", () -> {
            github.results
                    .shouldHave(sizeGreaterThan(1))
                    .first().shouldHave(text("Concise UI Tests with Java!"))
                    .find("a[data-hydro-click-hmac]").click();
        });

        step("The page should have title {GitHub - selenide/selenide: Concise UI Tests with Java!}", () -> {
            Selenide.Wait().until(titleIs("GitHub - selenide/selenide: Concise UI Tests with Java!"));
        });


    }


}


