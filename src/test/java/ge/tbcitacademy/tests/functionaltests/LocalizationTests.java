package ge.tbcitacademy.tests.functionaltests;

import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.steps.LocalizationSteps;
import ge.tbcitacademy.steps.StaysSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Epic("Localization")
public class LocalizationTests extends ConfigTests {

    StaysSteps staysSteps;
    LocalizationSteps localizationSteps;

    @BeforeClass
    public void setUp() {
        staysSteps = new StaysSteps();
        localizationSteps = new LocalizationSteps();
    }

    @BeforeMethod
    public void beforeMethod(){
        open(Constants.BOOKING_URL);
        staysSteps.closeSignInPopUp();
    }

    @Feature("Currency Switching")
    @Story("User can change currency")
    @Test(priority =1, description = "Verify that the user can successfully change the currency on Booking.com")
    public void testCurrencyChange() {

        localizationSteps
                .openCurrencyDropdown()
                .selectCurrency(Constants.US_DOLLAR)
                .verifyCurrency(Constants.USD);
    }

    @Feature("Language Switching")
    @Story("User can change language")
    @Test(priority = 2,description = "Verify that the user can successfully change the language on Booking.com")
    public void testLanguageChange() {
        localizationSteps
                .openLanguageDropdown()
                .selectLanguage(Constants.LANGUAGE)
                .verifyLanguage(Constants.LANGUAGE);
    }

}
