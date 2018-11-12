package lv.sikhvart.cucumber.pageobjects.craiglist;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CraiglistPage {

    public SelenideElement english() {
        return $(By.xpath("//a[@href='?lang=en&setlang=1']"));
    }

    public SelenideElement housing() {
        return $(By.xpath("//div[@class='housing'] //span[contains(text(), 'housing')]"));
    }

    public SelenideElement navigate() {
        open("http://craiglist.org");
        return english();
    }
}
