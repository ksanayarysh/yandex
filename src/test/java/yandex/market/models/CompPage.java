package yandex.market.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.market.locators.Locators;

import java.util.List;

import static yandex.market.locators.Locators.*;

public class CompPage extends BasePage {
    public CompPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
        click(openComparePage);
    }

    public void checkPhoneAmount(Integer amount){
        List<WebElement> phonesToCompare = wait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(Locators.phonesToCompare));
        assert phonesToCompare.size() == amount;
    }


    public void checkOSifAllCharacteristics() {
        click(allCharac);
        WebElement system = wait.until(ExpectedConditions.visibilityOfElementLocated(os));
        assert system.isDisplayed();

    }

    public void checkOSifDiffCharacteristics(){
        click(diffCharac);
        assert wait.until(ExpectedConditions.invisibilityOfElementLocated(os));

    }
}
