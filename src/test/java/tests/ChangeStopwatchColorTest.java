package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.IntroductionPageSteps;
import steps.PermissionPageSteps;
import steps.StopwatchPageSteps;

public class ChangeStopwatchColorTest extends AbstractStopwatchTest {

    private StopwatchPageSteps stopwatchPageSteps;
    private PermissionPageSteps permissionPageSteps;
    private IntroductionPageSteps introductionPageSteps;

    @BeforeTest
    public void setUp() {
        stopwatchPageSteps = new StopwatchPageSteps(driver);
        permissionPageSteps = new PermissionPageSteps(driver);
        introductionPageSteps = new IntroductionPageSteps(driver);
    }

    @Test(description = "[TC9] Change color of the stopwatch screen")
    public void changeToSquare() throws InterruptedException {
        permissionPageSteps.checkPageDisplayed().tapAllowButton();
        introductionPageSteps.checkPageDisplayed().tapLaterButton();
        stopwatchPageSteps.tapSettingsButton();
        stopwatchPageSteps.tapColorsPalette();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
