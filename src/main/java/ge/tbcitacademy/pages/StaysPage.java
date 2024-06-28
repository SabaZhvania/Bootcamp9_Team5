package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StaysPage extends CommonPage{
    public SelenideElement signInPopUpCloseButton = $(byAttribute("aria-label","Dismiss sign-in info."));
    public ElementsCollection promotionalOffers = $$("[data-testid='promotional-banner-container']"),
    navLinks = $$("nav[data-testid='header-xpb'] a");
}
