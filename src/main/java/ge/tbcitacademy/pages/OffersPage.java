package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class OffersPage extends CommonPage {
    public ElementsCollection offers = $$("div[data-testid='property-card-container']"),
                                offerAvailabilityButton = $$("a[data-testid='availability-cta-btn']");
}
