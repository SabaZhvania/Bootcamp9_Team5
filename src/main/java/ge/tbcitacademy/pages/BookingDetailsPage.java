package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BookingDetailsPage {
    public SelenideElement roomsAndPersonsChosen = $("h3.bui-accordion__title"),
                            checkInDate = $("time[aria-describedby='bp-checkin-date__label']")
                                    .$("span.bui-date__title"),
                            checkOutDate = $("time[aria-describedby='bp-checkout-date__label']")
                                    .$("span.bui-date__title"),
                            firstNameField = $("#firstname"),
                            lastNameField = $("#lastname"),
                            emailField = $("#email"),
                            telephoneNumberField = $("#phone"),
                            nextButton = $("button[name='book']");
}
