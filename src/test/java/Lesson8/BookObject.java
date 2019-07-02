package Lesson8;

public class BookObject {
    private String author;

    public BookObject(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return author;
    }
}
