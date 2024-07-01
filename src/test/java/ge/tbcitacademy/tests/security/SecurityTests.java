package ge.tbcitacademy.tests.security;

import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SecurityTests {

    StaysSteps staysSteps;
    SignInSteps signInSteps;
    @BeforeClass
    public void classSetup(){
        staysSteps = new StaysSteps();
        signInSteps = new SignInSteps();
    }
    @BeforeMethod
    public void testSetup(){
        open(Constants.BOOKING_URL);
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp();
    }

}
