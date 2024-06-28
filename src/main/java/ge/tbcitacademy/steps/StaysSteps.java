package ge.tbcitacademy.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.pages.StaysPage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import static com.codeborne.selenide.Condition.*;

public class StaysSteps extends CommonSteps {
    StaysPage staysPage = new StaysPage();

    @Step("Wait for page to load")
    public StaysSteps validatePageLoad() {
        staysPage.promotionalOffers.first().shouldBe(allOf(visible, clickable));
        staysPage.promotionalOffers.last().shouldBe(allOf(visible, clickable));
        return this;
    }

    @Step("Close the sign in or register pop up")
    public StaysSteps closeSignInPopUp() {
        try {
            staysPage.signInPopUpCloseButton.shouldBe(visible, Duration.ofSeconds(3));
            staysPage.signInPopUpCloseButton.click();
        } catch (NoSuchElementException | ElementNotFound e) {
            System.out.println("No pop up detected");
        }
        return this;
    }

    @Step("Validate search bar is visible")
    public StaysSteps validateSearchBarVisibility(){
        staysPage.searchButton.shouldBe(visible);
        return this;
    }

    @Step("Input text in search bar")
    public StaysSteps inputTextInSearchBar(String text){
        staysPage.destinationSearchBar.sendKeys(text);
        return this;
    }

    @Step("Click search button")
    public StaysSteps clickSearchBtn(){
        staysPage.searchButton.click();
        return this;
    }

    @Step("Validate search button is visible and clickable")
    public StaysSteps validateSearchBtn(){
        staysPage.searchButton.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate register button is visible and clickable")
    public StaysSteps validateRegisterBtn(){
        staysPage.registerBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate sign in button is visible and clickable")
    public StaysSteps validateSignInBtn(){
        staysPage.signInBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate language selector is visible and clickable")
    public StaysSteps validateLanguageSelectionBtn(){
        staysPage.languageSwitcherBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }

    @Step("Validate navigation bar")
    public StaysSteps validateNavBar(){
        staysPage.navLinks.shouldHave(CollectionCondition.containExactTextsCaseSensitive(
                Constants.STAYS, Constants.FLIGHTS, Constants.CAR_RENTALS
        ));
        return this;
    }

    @Step("Click navigation item")
    public StaysSteps clickNavItem(String text){
        staysPage.navLinks.filter(text(text)).get(0).click();
        return this;
    }

    @Step("Click sign in button")
    public StaysSteps clickSignInBtn(){
        staysPage.signInBtn.click();
        return this;
    }
}
