package ge.tbcitacademy.tests.functionaltests;


import com.github.javafaker.Faker;
import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.*;
import ge.tbcitacademy.util.UrlUtils;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

@Epic("Functional Tests")
public class AuthorizationTests extends ConfigTests {
    Logger LOGGER = LoggerFactory.getLogger(AuthorizationTests.class);
    SignInOrCreateSteps signInOrCreateSteps;
    RegistrationSteps registrationSteps;
    SignInSteps signInSteps;
    StaysSteps staysSteps;
    CommonSteps commonSteps;
    Faker faker;

    @BeforeClass
    public void setUp() {
        signInOrCreateSteps = new SignInOrCreateSteps();
        registrationSteps = new RegistrationSteps();
        staysSteps = new StaysSteps();
        signInSteps = new SignInSteps();
        commonSteps = new CommonSteps();
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod(){
        open(Constants.BOOKING_URL);
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp();
    }

    @Feature("Authorization")
    @Story("Registration Process")
    @Description("""
            This test case verifies the end-to-end user registration process,
            including handling invalid data and successful account creation.
            """)
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "User registration")
    public void registrationTest() {
        commonSteps
                .clickRegisterButton();

        signInOrCreateSteps
                .validateSignInOrCreatePage()
                .enterEmail(faker.internet().emailAddress().replace("@", "$"))
                .clickContinueBtn()
                .validateInvalidEmailErrorMessage()
                .clickSignInWithGoogleButton()
                .validateGoogleSignInPageOpened()
                .enterEmail(faker.internet().emailAddress())
                .clickContinueBtn();

        registrationSteps
                .fillPasswords(faker.internet().password(5, 6))
                .clickCreateAccountButton()
                .fillPasswords(faker.internet().password(10, 15, true, true))
                .clickCreateAccountButton();

        UrlUtils.validateUrlContainsParameters(Constants.AUTH_SUCCESS, Constants.ACCOUNT_CREATED);
    }

    @Feature("Authorization")
    @Story("Sign-In Process")
    @Description("""
            This test case verifies that a registered user can successfully sign in to the Booking website.
            """)
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, description = "User Sign in")
    public void signInTest() {
        Properties props = new Properties();
        try (InputStream input = AuthorizationTests.class.getClassLoader().getResourceAsStream(Constants.CONFIG)) {
            props.load(input);
        } catch (IOException ex) {
            LOGGER.error("Error loading properties file: ", ex);
        }

        String email = props.getProperty(Constants.EMAIL);
        String password = props.getProperty(Constants.PASSWORD);

        commonSteps
                .clickSignInBtn();
        signInOrCreateSteps
                .enterEmail(email)
                .clickContinueBtn();
        signInSteps
                .enterPassword(password)
                .clickSignInButtonOnSignInPage();

        UrlUtils.validateUrlContainsParameters(Constants.AUTH_SUCCESS);
    }
}
