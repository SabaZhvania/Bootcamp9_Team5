package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.StaysPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class LocalizationSteps {
    StaysPage staysPage = new StaysPage();

    @Step("Open currency dropdown")
    public LocalizationSteps openCurrencyDropdown() {
        staysPage.currencyButton.shouldBe(visible).click();
        return this;
    }

    @Step("Select currency: {currency}")
    public LocalizationSteps selectCurrency(String currency) {
        staysPage.currencyOption(currency).shouldBe(visible).click();
        return this;
    }

    @Step("Verify selected currency: {expectedCurrency}")
    public void verifyCurrency(String expectedCurrency) {
        staysPage.currencyButton.shouldHave(text(expectedCurrency));
    }

    @Step("Open language dropdown")
    public LocalizationSteps openLanguageDropdown() {
        staysPage.languageSwitcherBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Select language: {language}")
    public LocalizationSteps selectLanguage(String language) {
        staysPage.languageOption(language).shouldBe(visible).click();
        return this;
    }

    @Step("Verify selected language: {expectedLanguage}")
    public void verifyLanguage(String expectedLanguage) {
        String expectedAriaLabel = "Sprache: " + expectedLanguage;
        staysPage.languageSwitcherBtn.shouldHave(attribute("aria-label", expectedAriaLabel));
    }
}
