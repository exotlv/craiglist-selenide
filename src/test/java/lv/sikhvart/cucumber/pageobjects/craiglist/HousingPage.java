package lv.sikhvart.cucumber.pageobjects.craiglist;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
//    public void checkHighPrice() {
//        WebElementHelper.click(dropdown);
//        WebElementHelper.waitForVisibility(priceHigh);
//        WebElementHelper.click(priceHigh);
//        WebElementHelper.waitForVisibility(highPriceSorting);
//    }
//
//    public void checkLowestPrice() {
//        WebElementHelper.click(dropdown);
//        WebElementHelper.waitForVisibility(priceLow);
//        WebElementHelper.click(priceLow);
//        WebElementHelper.waitForVisibility(lowestPriceSorting);
//    }
//
//    public void addTextInSearch(String text) {
//        WebElementHelper.waitForVisibility(searchField);
//        WebElementHelper.sendKeys(searchField, text);
//        WebElementHelper.click(searchIcon);
//    }
//
//    public void checkDropdownAfterSearch() {
//        WebElementHelper.waitForVisibility(dropdown);
//        WebElementHelper.click(dropdown);
//        WebElementHelper.waitForVisibility(newest);
//        WebElementHelper.waitForVisibility(priceLow);
//        WebElementHelper.waitForVisibility(priceHigh);
//        WebElementHelper.waitForVisibility(relevant);
//        WebElementHelper.waitForVisibility(upcoming);
//    }

}

