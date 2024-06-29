package ge.tbcitacademy.tests.functionaltests;


import com.github.javafaker.Faker;
import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.RegistrationSteps;
import ge.tbcitacademy.steps.SignInSteps;
import ge.tbcitacademy.steps.StaysSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

@Epic("User Authorization")
public class AuthorizationTests extends ConfigTests {
    Logger LOGGER = LoggerFactory.getLogger(AuthorizationTests.class);
    RegistrationSteps registrationSteps;
    SignInSteps signInSteps = new SignInSteps();

    StaysSteps staysSteps;

    @BeforeClass
    public void setUp() {
        registrationSteps = new RegistrationSteps();
        staysSteps = new StaysSteps();
    }

    @BeforeMethod
    public void beforeMethod(){
        open(Constants.BOOKING_URL);
        staysSteps.closeSignInPopUp();
    }


    @Feature("Registration Process")
    @Story("User Registration Flow")
    @Test(priority = 1, description = "This test case verifies the end-to-end user registration process, " +
            "including handling invalid data and successful account creation.")
    public void testRegistration() {
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();

        registrationSteps
                .clickRegisterButton()
                .validateLoginPage()
                .enterInvalidEmail(faker.internet().emailAddress().replace("@", "$"))
                .validateInvalidEmailErrorMessage()
                .clickSignInWithGoogleButton();
        softAssert.assertTrue(registrationSteps.isGoogleSignInPageOpened(), Constants.GOOGLE_VALIDATION);
        registrationSteps.enterValidEmail(faker.internet().emailAddress())
                .enterInvalidPassword(faker.internet().password(5, 6))
                .enterValidPassword(faker.internet().password(10, 15, true, true))
                .clickCreateAccountButton()
                .validateUrlContainsParameters(Constants.AUTH_SUCCESS, Constants.ACCOUNT_CREATED);
        softAssert.assertAll();
    }

    @Feature("Sign-In Process")
    @Story("Successful Sign-In")
    @Test(priority = 2, description = "This test case verifies that a registered user can" +
            "successfully sign in to the Booking website.")
    public void testSignIn() {
        Properties props = new Properties();
        try (InputStream input = AuthorizationTests.class.getClassLoader().getResourceAsStream(Constants.CONFIG)) {
            props.load(input);
        } catch (IOException ex) {
            LOGGER.error("Error loading properties file: ", ex);
        }

        String email = props.getProperty(Constants.EMAIL);
        String password = props.getProperty(Constants.PASSWORD);

        signInSteps
                .clickSignInButton()
                .enterEmail(email)
                .clickContinueWithEmailButton()
                .enterPassword(password)
                .clickSignInButtonOnSignInPage();

        registrationSteps.validateUrlContainsParameters(Constants.AUTH_SUCCESS);
    }
}
