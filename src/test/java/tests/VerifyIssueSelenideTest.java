package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;

public class VerifyIssueSelenideTest {

    private final static String url = "https://github.com";
    private final static String repository = "eroshenkoam/allure-example";
    private final static int issueNumber = 68;

    @Test
    public void verifyIssueOnGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(url);
        $("[name='q']").setValue(repository).pressEnter();
        $("ul.repo-list li a").click();
        $(byText("Issues")).click();
        $("#issue_"+ issueNumber +"_link").should(Condition.exist);
    }
}
