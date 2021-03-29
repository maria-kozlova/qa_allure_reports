package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GitHubPage;

public class StepAnnotationTest {

    GitHubPage gitHubPage = new GitHubPage();

    @Test
    @DisplayName("Verify Issue exists")
    public void verifyIssueExists(){
        gitHubPage.openGitHUb();
        gitHubPage.openRepository();
        gitHubPage.openIssues();
        gitHubPage.verifyIssueExists();
    }
}
