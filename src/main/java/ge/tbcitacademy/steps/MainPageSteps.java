package ge.tbcitacademy.steps;


import com.codeborne.selenide.CollectionCondition;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.pages.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    @Step("Validate search bar is visible")
    public MainPageSteps validateSearchBarVisibility(){
        mainPage.searchBar.shouldBe(visible);
        return this;
    }

    @Step("Input text in search bar")
    public MainPageSteps inputTextInSearchBar(String text){
        mainPage.searchBar.sendKeys(text);
        return this;
    }

    @Step("Click search button")
    public MainPageSteps clickSearchBtn(){
        mainPage.searchBtn.click();
        return this;
    }

    @Step("Validate search button is visible and clickable")
    public MainPageSteps validateSearchBtn(){
        mainPage.searchBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate register button is visible and clickable")
    public MainPageSteps validateRegisterBtn(){
        mainPage.registerBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate sign in button is visible and clickable")
    public MainPageSteps validateSignInBtn(){
        mainPage.signInBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate language selector is visible and clickable")
    public MainPageSteps validateLanguageSelectionBtn(){
        mainPage.languageSwitcherBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate navigation bar")
    public MainPageSteps validateNavBar(){
        mainPage.navLinks.shouldHave(CollectionCondition.containExactTextsCaseSensitive(
                Constants.stays, Constants.flights, Constants.carRentals
        ));
        return this;
    }

    @Step("Click navigation item")
    public MainPageSteps clickNavItem(String text){
        mainPage.navLinks.filter(text(text)).get(0).click();
        return this;
    }

    @Step("Validate stays page is visible")
    public MainPageSteps validateStaysPage(){
        mainPage.bannerSubTitle.shouldBe(visible);
        return this;
    }

    @Step("Click sign in button")
    public MainPageSteps clickSignInBtn(){
        mainPage.signInBtn.click();
        return this;
    }
}
