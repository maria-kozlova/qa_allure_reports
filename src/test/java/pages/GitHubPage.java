package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubPage {
    private final static String url = "https://github.com";
    private final static String repository = "eroshenkoam/allure-example";
    private final static int issueNumber = 68;

    @Step("Open GitHubPage")
    public void openGitHUb(){
        open(url);
    }

    @Step("Open Repository"+repository)
    public void openRepository() {
        $("[name='q']").setValue(repository).pressEnter();
        $("ul.repo-list li a").click();
    }

    @Step("Open Issue Tab")
    public void openIssues() {
        $(byText("Issues")).click();
    }

    @Step("verify Issue number "+issueNumber+" exists")
    public void verifyIssueExists() {
        $("#issue_"+issueNumber+"_link").should(Condition.exist);
    }

}
