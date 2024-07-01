package ge.tbcitacademy.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.pages.FiltersPage;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class FilterSteps {
    Actions actions = new Actions(WebDriverRunner.getWebDriver());
    FiltersPage filtersPage = new FiltersPage();

    @Step("Set budget filter to min - max")
    public void setBudgetFilter(int min, int max) {
        actions.click(filtersPage.min).clickAndHold(filtersPage.max).perform();
        while (!Objects.equals(filtersPage.minVal.getValue(), String.valueOf(min))) {
            actions.moveByOffset(5, 0).perform();
        }

        actions.click(filtersPage.max).clickAndHold(filtersPage.max).perform();
        while (!Objects.equals(filtersPage.maxVal.getValue(), String.valueOf(max))) {
            actions.moveByOffset(-5, 0).perform();
        }
    }
    @Step("Check review score filter 'Wonderful: 9+'")
    public FilterSteps setReviewScoreFilter() {
        filtersPage.reviewScoreCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Check property rating filter '4 stars'")
    public FilterSteps setPropertyRatingFilter() {
        filtersPage.propertyRatingCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Validate that all offers are within the budget range 100 - 120")
    public FilterSteps validateBudgetFilter(int min, int max) {
        filtersPage.offerPrices.forEach(priceElement -> {
            String priceText = priceElement.getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);
            assertTrue(price >= min && price <= max, "Price out of range: " + price);
        });
        return this;
    }

    @Step("Validate that all offers have a review score of at least 9.0")
    public FilterSteps validateReviewScoreFilter() {
        filtersPage.reviewScores.forEach(scoreElement -> {
            String scoreText = scoreElement.getText().replaceAll("[^0-9.]", "");
            double score = Double.parseDouble(scoreText);
            assertTrue(score >= 9.0, "Review score less than 9: " + score);
        });
        return this;
    }

    @Step("Validate that all offers have a 4-star rating")
    public FilterSteps validatePropertyRatingFilter() {
        filtersPage.propertyRatings.forEach(ratingElement -> {
            String rating = ratingElement.getText().replaceAll("[^0-9]", "");
            assertTrue(rating.equals("4"), "Property rating is not 4 stars: " + rating);
        });
        return this;
    }
}
