package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbcitacademy.pages.CommonPage;
import io.qameta.allure.Step;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class CommonSteps {
    CommonPage commonPage = new CommonPage();

    @Step("Close Genius membership popup if it appears")
    public CommonSteps closeGeniusPopup() {
        try{
            commonPage.geniusPopUpCloseBtn.shouldBe(visible).click();
        }
        catch(ElementNotFound ignored){}
        return this;
    }

    @Step("Click on the destinations search bar")
    public CommonSteps clickDestinationSearchBar() {
        commonPage.destinationSearchBar.shouldBe(clickable).click();
        return this;
    }

    @Step("Accepts cookies offered by the website")
    public void acceptCookies() {
        try{
            commonPage.cookieAcceptBtn.shouldBe(clickable).click();
        }
        catch(ElementNotFound ignored){}
    }

    @Step("Choose first offered destination")
    public CommonSteps chooseFirstDestination() {
        commonPage.firstDestination.click();
        return this;
    }

    @Step("Pick stay dates")
    public CommonSteps pickDates(LocalDate startDate, LocalDate endDate){
        if (!commonPage.datePickerTab.is(visible)) {
            commonPage.datePickerSearchBar.click();
        }
        commonPage.date(startDate).click();
        commonPage.date(endDate).click();
        return this;
    }

    @Step("Click on the 'Search' button")
    public CommonSteps clickSearch(){
        commonPage.searchButton.click();
        return this;
    }

    @Step("Navigate to previous page")
    public CommonSteps navigateBack(){
        Selenide.back();
        return this;
    }

    @Step("Click Sign in button at the top of the page")
    public void clickSignInBtn(){
        commonPage.signInBtn.shouldBe(visible).click();
    }

    @Step("Click 'Register' button")
    public void clickRegisterButton() {
        commonPage.registerBtn.click();
    }

    @Step("Open currency dropdown")
    public CommonSteps openCurrencyDropdown() {
        commonPage.currencyButton.shouldBe(visible).click();
        return this;
    }

    @Step("Select currency: {currency}")
    public CommonSteps selectCurrency(String currency) {
        commonPage.currencyOption(currency).shouldBe(visible).click();
        return this;
    }

    @Step("Open language dropdown")
    public CommonSteps openLanguageDropdown() {
        commonPage.languageSwitcherBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Select language: {language}")
    public CommonSteps selectLanguage(String language) {
        commonPage.languageOption(language).shouldBe(visible).click();
        return this;
    }
}
