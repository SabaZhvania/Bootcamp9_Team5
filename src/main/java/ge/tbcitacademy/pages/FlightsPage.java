package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FlightsPage {
    public SelenideElement title = $(byText("Search hundreds of flight sites at once."));
}
