package ge.tbcitacademy.tests.functionaltests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import ge.tbcitacademy.configtests.ConfigTests;
import ge.tbcitacademy.listeners.CustomTestListener;
import ge.tbcitacademy.steps.*;
import ge.tbcitacademy.util.ModdedAllureSelenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.*;

@Epic("Functional Test")
public class BookingTest extends ConfigTests {
    StaysSteps staysSteps;
    CommonSteps commonSteps;
    OffersSteps offersSteps;
    HotelSteps hotelSteps;
    BookingDetailsSteps detailsSteps;
    FinalDetailsSteps finalDetailsSteps;
    Faker faker;
    String hotelName;
    String price;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        staysSteps = new StaysSteps();
        commonSteps = new CommonSteps();
        offersSteps = new OffersSteps();
        hotelSteps = new HotelSteps();
        detailsSteps = new BookingDetailsSteps();
        finalDetailsSteps = new FinalDetailsSteps();
        faker = new Faker();
        open(BOOKING_URL);
    }

    @Feature("Booking Process")
    @Story("Booking without card info")
    @Test(testName = "Hotel booking and payment", description = """
            This test case simulates user choosing destination, check-in&out dates and picking first offer.
            User fills personal details, but doesn't provide card info, so he/she gets appropriate error messages.
            """)
    public void bookingAndPaymentTest(){
        staysSteps
                .validatePageLoad()
                .closeSignInPopUp();

        commonSteps
                .clickDestinationSearchBar()
                .chooseFirstDestination()
                .pickDates(CHECK_IN_DATE, CHECK_OUT_DATE)
                .clickSearch();

        offersSteps
                .pickFirstOffer()
                .switchWindow();

        hotelName = hotelSteps.getHotelName();
        hotelSteps.clickReserve();
        price = hotelSteps.getReservationPrice();
        hotelSteps.clickIllReserve();

        detailsSteps
                .validateDetails(ROOMS_AND_PERSONS_DETAIL, CHECK_IN, CHECK_OUT)
                .fillName(faker.name().firstName())
                .fillLastName(faker.name().lastName())
                .fillMail(faker.internet().emailAddress())
                .fillNumber(faker.phoneNumber().cellPhone())
                .clickNext();

        finalDetailsSteps
                .validateLoad()
                .clickCheckBookingBtn()
                .validateFinalDetails(hotelName, CHECK_IN, CHECK_OUT, price)
                .clickLooksGoodSubmit()
                .validateErrors();
    }
}
