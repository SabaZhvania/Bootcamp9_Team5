package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.HotelPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class HotelSteps {
    HotelPage hotelPage = new HotelPage();

    @Step("Get hotel name")
    public String getHotelName() {
        return hotelPage.hotelName.should(exist).getText();
    }

    @Step("Click the 'Reserve' button")
    public void clickReserve() {
        hotelPage.reserveButton.shouldBe(visible).click();
    }

    @Step("Get hotel reservation price")
    public String getReservationPrice() {
        return hotelPage.reservationPrice.shouldBe(visible).getText();
    }
    @Step("Click 'I'll reserve' button")
    public void clickIllReserve() {
        hotelPage.iWillReserveButton.click();
    }
}
