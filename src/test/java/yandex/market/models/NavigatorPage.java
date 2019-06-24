package yandex.market.models;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.market.locators.Locators;
import java.util.List;
import static yandex.market.locators.Locators.*;

public class NavigatorPage extends BasePage {
    public NavigatorPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public ProductsPage filterManufacturer(String nameOne, String nameTwo){
        WebElement manufacturerBox = wait.until(ExpectedConditions.
                presenceOfElementLocated(Locators.manufacturerBox));

        List<WebElement> manList = manufacturerBox.findElements(manufacturers);
        ((JavascriptExecutor)wd).executeScript("window.scrollBy(0, 500);");

        for (WebElement man:manList) {
            if (man.getText().contains(nameOne) || man.getText().contains(nameTwo))
                man.click();
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allPhones));
        return new ProductsPage(wd, wait);
    }
}
