package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.pages.OffersPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class OffersSteps {
    OffersPage offersPage = new OffersPage();

    @Step("Click first offers availability button")
    public OffersSteps pickFirstOffer() {
        offersPage.offers.first().shouldBe(visible);
        offersPage.offerAvailabilityButton.first().shouldBe(visible).click();
        return this;
    }

    @Step("Switch to newly opened browser window")
    public void switchWindow() {
        Selenide.switchTo().window(1);
    }
}
