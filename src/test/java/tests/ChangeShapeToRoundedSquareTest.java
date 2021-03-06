package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.IntroductionPageSteps;
import steps.PermissionPageSteps;
import steps.StopwatchPageSteps;

public class ChangeShapeToRoundedSquareTest extends AbstractStopwatchTest {

    private StopwatchPageSteps stopwatchPageSteps;
    private PermissionPageSteps permissionPageSteps;
    private IntroductionPageSteps introductionPageSteps;

    @BeforeTest
    public void setUp() {
        stopwatchPageSteps = new StopwatchPageSteps(driver);
        permissionPageSteps = new PermissionPageSteps(driver);
        introductionPageSteps = new IntroductionPageSteps(driver);
    }

    @Test(description = " [TC6] Change shape of the stopwatch screen to rounded square")
    public void changeToSquare() throws InterruptedException {
        permissionPageSteps.checkPageDisplayed().tapAllowButton();
        introductionPageSteps.checkPageDisplayed().tapLaterButton();
        stopwatchPageSteps.tapSettingsButton();
        stopwatchPageSteps.tapRoundedSquareButton();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void restartApp() {
        driver.resetApp();
    }
}
