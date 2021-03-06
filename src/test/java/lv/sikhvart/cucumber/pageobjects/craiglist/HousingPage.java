package lv.sikhvart.cucumber.pageobjects.craiglist;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class HousingPage {

    public SelenideElement priceLow() {
        return $(".dropdown-list .dropdown-item a[data-selection=\"priceasc\"]");
    }

    public SelenideElement priceHigh() {
        return $(".dropdown-list .dropdown-item a[data-selection=\"pricedsc\"]");
    }

    public SelenideElement newest() {
        return $(".dropdown-list .dropdown-item a[data-selection=\"date\"]");
    }

    public SelenideElement clickHousing() {
        return $(By.xpath("//a[@class=\'hhh\']//span[@class=\'txt\']"));
    }

    public SelenideElement dropdown() {
        return $(".search-sort .dropdown-list");
    }

    public SelenideElement highPriceSorting() {
        return $(".rows .result-row[data-pid='6738320977']");
    }

    public SelenideElement lowestPriceSorting() {
        return $(".rows .result-row[data-pid='6737425971']");
    }

    public SelenideElement upcoming() {
        return $(".dropdown-list .dropdown-item a[data-selection=\"upcoming\"]");
    }

    public SelenideElement relevant() {
        return $(".dropdown-list .dropdown-item a[data-selection=\"rel\"]");
    }

    public SelenideElement inputField() {
        return $(By.name("query"));
    }

    public void searchFor(String textToSearchFor) {
        inputField().val(textToSearchFor).pressEnter();

    }
}

