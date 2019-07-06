package Lesson8.models;

import Lesson8.BookObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Lesson8.locators.Locator.*;

public class SingleBookPage extends BasePage {
    public SingleBookPage(WebDriver wd, WebDriverWait wait) {
        super(wd, wait);
    }

    public BookObject getBook() {
        String bookStr = wd.getCurrentUrl();

        bookStr = bookStr.concat(";").concat(
                wd.findElement(book_name).getText());

        List<WebElement> authors = wd.findElements(book_author);
        bookStr = bookStr.concat(";").concat(authors.get(0).getText());
        for (int i = 1; i < authors.size(); i++)
            bookStr = bookStr.concat(",").concat(authors.get(i).getText());

        WebElement price = wd.findElement(audio_price);
        bookStr = bookStr.concat(";").concat(price.getText());

        try {
            String fragment = wd.findElement(download_link).getAttribute("href");
            bookStr = bookStr.concat(";").concat(fragment);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            bookStr = bookStr.concat(";;");
        }


        return new BookObject(bookStr);
    }
}

