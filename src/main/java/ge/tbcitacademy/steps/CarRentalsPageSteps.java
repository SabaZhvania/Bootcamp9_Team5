package ge.tbcitacademy.steps;


import ge.tbcitacademy.pages.CarRentalsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class CarRentalsPageSteps {
    CarRentalsPage carRentalsPage = new CarRentalsPage();

    @Step("Validate rentals page is displayed")
    public CarRentalsPageSteps validateRentalsPage(){
        carRentalsPage.rentalText.shouldBe(visible);
        return this;
    }
}
