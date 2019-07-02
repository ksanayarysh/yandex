package Lesson8.models;

import Lesson8.BookObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class SingleBookPage extends BasePage {
    public SingleBookPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public BookObject getBook() {
        String bookStr = wd.getCurrentUrl();

        bookStr = bookStr.concat(";").concat(
                wd.findElement(By
                        .cssSelector("div[class=\"l-book-description position-top\"] div[class=\"b-headers\"]"))
                        .getText());

        List<WebElement> authors = wd.findElements(By.cssSelector(
                "div[class=\"l-book-description position-top\"] span[class=\"author active\"]"));
        bookStr = bookStr.concat(";").concat(authors.get(0).getText());
        for (int i = 1; i < authors.size(); i++)
            bookStr = bookStr.concat(",").concat(authors.get(i).getText());

        WebElement price = wd
                .findElement(By.cssSelector("div[ng-if=\"bookData.types.audiobook.sale\"] div[class=\"p-tab__price ng-binding\"]"));
        bookStr = bookStr.concat(";").concat(price.getText());

        try {
            String fragment = wd.findElement(By.className("nkk-file-download__link")).getAttribute("href");
            bookStr = bookStr.concat(";").concat(fragment);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            bookStr = bookStr.concat(";;");
        }


        return new BookObject(bookStr);
    }
}
