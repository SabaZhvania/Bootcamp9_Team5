package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.pages.FinalDetailsPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static ge.tbcitacademy.data.Constants.*;

public class FinalDetailsSteps {
    FinalDetailsPage detailsPage = new FinalDetailsPage();

    @Step("ValidatePageLoad")
    public FinalDetailsSteps validateLoad() {
        detailsPage.paymentFrame.should(exist, Duration.ofSeconds(15));
        Selenide.switchTo().frame(detailsPage.paymentFrame);
        detailsPage.cardDetailsSection.shouldBe(visible, Duration.ofSeconds(5));
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("Scroll down to 'Check your booking' button and click it")
    public FinalDetailsSteps clickCheckBookingBtn() {
        detailsPage.checkYourBookingBtn.scrollTo().shouldBe(visible).click();
        return this;
    }

    @Step("Validate hotel name")
    public FinalDetailsSteps validateFinalDetails(String hotelName, String checkInDate, String checkOutDate, String price) {
        detailsPage.offerName.shouldBe(text(hotelName));
        detailsPage.checkInDate.shouldHave(text(checkInDate));
        detailsPage.checkOutDate.shouldHave(text(checkOutDate));
        detailsPage.price.shouldHave(text(price));
        return this;
    }

    @Step("Click 'Looks good, complete my booking!' button")
    public FinalDetailsSteps clickLooksGoodSubmit() {
        detailsPage.looksGoodCompleteBookingBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Validate error messages")
    public void validateErrors() {
        detailsPage.paymentFrame.should(exist, Duration.ofSeconds(15));
        Selenide.switchTo().frame(detailsPage.paymentFrame);
        detailsPage.cardNumberErrorMsg.shouldHave(text(CARD_N_ERROR_MSG));
        detailsPage.expirationDateErrorMsg.shouldHave(text(EXPIRATION_ERROR_MSG));
        detailsPage.cvcErrorMsg.shouldHave(text(CVC_ERROR_MSG));
    }

}
