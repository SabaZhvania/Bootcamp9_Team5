package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CarRentalsPage {
    public SelenideElement rentalText = $(byText("Car rentals for any kind of trip"));
}
