package Lesson8;

import Lesson8.models.SingleBookPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Crawler {
    private static WebDriver wd;
    private static WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);
    private List<BookObject> all_books = new ArrayList<BookObject>();

    @BeforeClass
    public static void seUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--headless");
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 180);
        wd.manage().window().maximize();
    }

    @Test
    public void clawler() throws IOException, InterruptedException {
        wd.get("https://www.mann-ivanov-ferber.ru/books/allbooks/?booktype=audiobook");

        List<WebElement> books = wd.findElements(By.cssSelector("[class=\"lego-book size-0_50x  js-item  image-loaded\"]"));
        int booksSize = books.size();
        logger.info(String.valueOf(booksSize));
        while (true) {
            ((JavascriptExecutor)wd).executeScript("window.scrollBy(0, 500);");
            sleep(2000);
            int newBookSize = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector("[class=\"lego-book size-0_50x  js-item  image-loaded\"]"))).size();
            logger.info(String.valueOf(newBookSize));
            if (booksSize == newBookSize)
                break;
            booksSize = newBookSize;
        }
        ((JavascriptExecutor)wd).executeScript("window.scrollTo(0, 0);");
        sleep(5000);
        books = wd.findElements(By.cssSelector("[class=\"lego-book size-0_50x  js-item  image-loaded\"]"));
        logger.info(String.valueOf(books.size()));
        String mainWindow = wd.getWindowHandle();

        for (int i = 0; i< 43; i++){
            books.get(i).click();
            Set<String> tabs = wd.getWindowHandles();
            for (String tab:tabs){
                if (!(tab.equals(mainWindow))) {
                    wd.switchTo().window(tab);
                    logger.info(tab);
                    all_books.add(new SingleBookPage(wd).getBook());
                    wd.close();
                    wd.switchTo().window(mainWindow);
                }
            }
            logger.info(tabs.toString());
        }
        logger.info(all_books.toString());
        saveToFile();
    }


    private void saveToFile() throws IOException {
        FileWriter writer = new FileWriter("books.txt");
        for (BookObject book: all_books){
            writer.write(book.toString() + "\n");
        }
        writer.close();

    }


    @AfterClass
    public static void tearDown(){
        if (wd != null)
            wd.quit();
    }
}
