package yandex.market.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;
import static yandex.market.locators.Locators.*;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public ProductsPage init() {
        wd.get("https://www.yandex.ru/");
        wd.get("https://market.yandex.ru/");
        return this;
    }

    public ProductsPage allCatsClick() {
        click(allCategories);
        return this;
    }

    public ProductsPage phoneCellsClick() {
        click(mobilePhones);
        return this;
    }

    public NavigatorPage sortByPrice() {
        click(sortByPrice);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[contains(@title, \"\")]")));
        return new NavigatorPage(wd, wait);
    }

    public void getPhoneChosen(String phoneName) {

        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.
                format("//img[contains(@title, \"%s\")]", phoneName))));
        we.click();
        click(By.xpath("//span[contains(text(), \"Сравнить\")]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(notification));
        wd.navigate().back();
    }


}
