package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StaysPage extends CommonPage{
    public SelenideElement signInPopUpCloseButton = $(byAttribute("aria-label","Dismiss sign-in info.")),
                promotionalOffersHeaderText = $(".fc5c5a92af .b5138f45ca");
    public ElementsCollection promotionalOffers = $$("[data-testid='promotional-banner-container']"),
    navLinks = $$("nav[data-testid='header-xpb'] a");
    public SelenideElement destinationSearchBar = $(By.name("ss"));
    public SelenideElement searchButton = $("button[type='submit']");
}
