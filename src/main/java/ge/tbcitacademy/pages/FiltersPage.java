package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FiltersPage {
    public SelenideElement min = $$(".d6ed9c72b9").first();
    public SelenideElement max = $$(".d6ed9c72b9").last();
    public SelenideElement minVal = $$(".e8499c6a5c .c3e951fba5").first();
    public SelenideElement maxVal = $$(".e8499c6a5c .c3e951fba5").last();
    public SelenideElement reviewScoreCheckbox = $(byText("Wonderful: 9+"));
    public SelenideElement propertyRatingCheckbox = $(byText("4 stars"));
    public ElementsCollection reviewScores = $$("div[data-testid='review-score']");
    public ElementsCollection propertyRatings = $$("div[data-testid='rating']");
}
