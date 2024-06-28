package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage extends CommonPage{
    public SelenideElement signInPopUpCloseButton = $("button[aria-label='Dismiss sign-in info.'] .e36d74a87e");

    public ElementsCollection promotionalOffers = $$("[data-testid='promotional-banner-container']");
}
