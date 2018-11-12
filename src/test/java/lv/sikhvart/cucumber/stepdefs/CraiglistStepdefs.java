package lv.sikhvart.cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import lv.sikhvart.cucumber.pageobjects.craiglist.CraiglistPage;
import lv.sikhvart.cucumber.pageobjects.craiglist.HousingPage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CraiglistStepdefs {

    private CraiglistPage CraiglistPage;
    private HousingPage HousingPage;

    public CraiglistStepdefs() {
        CraiglistPage = new CraiglistPage();
        HousingPage = new HousingPage();
    }

    @Given("^open craiglist webpage$")
    public void openCraiglistPage() throws Throwable {
        CraiglistPage = new CraiglistPage();
        CraiglistPage.navigate();
    }

    @Given("^select language English$")
    public void selectLanguageEnglish() throws Throwable {
        CraiglistPage = new CraiglistPage();
        CraiglistPage.english().scrollIntoView(true).shouldBe(visible);
        CraiglistPage.english().click();
        CraiglistPage.housing().scrollIntoView(true).shouldBe(visible);
    }

    @And("^check filters in dropdown$")
    public void checkPricesFilterIndropdown() throws Throwable {
        HousingPage = new HousingPage();
        HousingPage.clickHousing().scrollIntoView(true).shouldBe(visible).click();
        HousingPage.dropdown().shouldBe(visible).click();
        HousingPage.newest().shouldBe(visible);
        HousingPage.priceHigh().shouldBe(visible);
        HousingPage.priceLow().shouldBe(visible);
        HousingPage.dropdown().shouldBe(visible).click();
    }


    @And("^check High price sorting$")
    public void checkHighPriceSorting() throws Throwable {
        HousingPage.dropdown().click();
        HousingPage.priceHigh().shouldBe(visible).click();
        HousingPage.highPriceSorting().shouldBe(visible);
        $$(".result-row .result-image .result-price").first(3).shouldHave(texts("€869857", "€1100", "€900"));
    }

    @And("^check Lowest price sorting$")
    public void checkLowestPriceSorting() throws Throwable {
        HousingPage.dropdown().click();
        HousingPage.priceLow().shouldBe(visible).click();
        HousingPage.lowestPriceSorting().shouldBe(visible);
        $$(".result-row .result-image .result-price").first(3).shouldHave(texts("€299", "€400", "€400"));
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchItem) throws Throwable {
        HousingPage.searchFor(searchItem);
    }

    @And("^check dropdown sorting after search$")
    public void checkDropdownSortingAfterSearch() throws Throwable {
        HousingPage.dropdown().click();
        HousingPage.newest().shouldBe(visible);
        HousingPage.priceHigh().shouldBe(visible);
        HousingPage.priceLow().shouldBe(visible);
        HousingPage.upcoming().shouldBe(visible);
        HousingPage.relevant().shouldBe(visible);
    }
//
//    @And("^add predefined text in search field$")
//    public void addReviewData() throws Throwable {
//        HousingPage = new HousingPage();
//        HousingPage.openHousingPage();
//        HousingPage.addTextInSearch(ApplicationProperties.getString(TEST_DATA));
//    }
//
}

