package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private final static String url = "https://github.com";
    private final static String repository = "eroshenkoam/allure-example";
    private final static int issueNumber = 68;

    @Test
    void verifyIssueOnGitHub() {
        Allure.feature("GitHub");
        Allure.story("Repository Issues");

        step("Open GitHub page", () -> {
            open(url);
        });

        step("Open Repository "+repository, () -> {
                    $("[name='q']").setValue(repository).pressEnter();
                    $("ul.repo-list li a").click();
                });

        step("Open Issue Tab ", () -> {
                    $(byText("Issues")).click();
                });

        step("Verify Issue "+issueNumber+" exists", () -> {
            $("#issue_" + issueNumber + "_link").should(Condition.exist);
        });

    }
}
