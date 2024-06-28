package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SearchPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SearchPageSteps {
    SearchPage searchPage = new SearchPage();

    @Step
    public SearchPageSteps validateOffersVisibility(){
        searchPage.offers.forEach(e -> e.shouldBe(visible));
        return this;
    }

    @Step
    public SearchPageSteps validateFiltersPresence(){
        searchPage.popularFilters.filter(visible).forEach(f -> f.shouldBe(interactable));
        return this;
    }

    @Step
    public SearchPageSteps validateSortBtn(){
        searchPage.sortBtn.shouldBe(visible).shouldBe(clickable);
        return this;
    }
}
