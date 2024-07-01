package ge.tbcitacademy.tests.security;

import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.SignInSteps;
import ge.tbcitacademy.steps.StaysSteps;
import ge.tbcitacademy.steps.TimingAtackSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.SQL_INJECTION_SCRIPT;

@Feature("Security Tests")
public class SecurityTests extends ConfigTests {
    SignInSteps signInSteps;
    StaysSteps staysSteps;
    TimingAtackSteps timingAtackSteps;

    @BeforeClass
    public void setUp() {
        signInSteps = new SignInSteps();
        staysSteps = new StaysSteps();
        timingAtackSteps = new TimingAtackSteps().initializeSteps();
    }

    @BeforeMethod
    public void beforeMethod() {
        open(Constants.BOOKING_URL);
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp();
    }

    @Story("SQL Injection")
    @Description("""
            Verify that the application properly handles SQL injection attempts.
            """)
    @Test(priority = 1, description = "Test for SQL injection vulnerability")
    public void testSQLInjection() {
        staysSteps
                .enterDestination(SQL_INJECTION_SCRIPT)
                .clickSearchButton()
                .checkIfErrorIsDisplayed();
    }

    @Story("Timing Attack")
    @Description("""
        Verify that the application properly handles timing attacks to avoid information leakage.
        """)
    @Test(priority = 1, description = "Test for timing attack vulnerability")
    public void testTimingAttack() {
        open(Constants.BOOKING_SIGN_IN_URL);
        signInSteps
                .enterEmail()
                .clickSignInButtonOnSignInPage();

        timingAtackSteps.performAttack()
                .validateConsistency();
    }

}
