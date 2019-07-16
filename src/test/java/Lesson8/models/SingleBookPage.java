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
        BookObject book = new BookObject();
        book.setLink(wd.getCurrentUrl());
        book.setName(wd.findElement(book_name).getText());


        String authorsStr;
        List<WebElement> authors = wd.findElements(book_author);
        authorsStr = authors.get(0).getText();
        for (int i = 1; i < authors.size(); i++) {
            authorsStr = authorsStr.concat(",").concat(authors.get(i).getText());
        }
        book.setAuthor(authorsStr);

        book.setPrice(wd.findElement(audio_price).getText());

        try {
            String fragment = wd.findElement(download_link).getAttribute("href");
            book.setLinkIntro(fragment);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            book.setLinkIntro("");
        }


        return book;
    }
}

