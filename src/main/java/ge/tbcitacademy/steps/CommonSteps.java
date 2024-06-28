package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.pages.CommonPage;
import io.qameta.allure.Step;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.visible;

public class CommonSteps {
    CommonPage commonPage = new CommonPage();
    
    @Step("Click on the destinations search bar")
    public CommonSteps clickDestinationSearchBar() {
        commonPage.destinationSearchBar.click();
        return this;
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
    public void clickSearch(){
        commonPage.searchButton.click();
    }

    @Step("Navigate to previous page")
    public CommonSteps navigateBack(){
        Selenide.back();
        return this;
    }
}
