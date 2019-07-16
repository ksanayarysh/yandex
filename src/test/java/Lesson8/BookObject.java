package Lesson8;

public class BookObject {
    private String author;
    private String link;
    private String name;
    private String price;
    private String linkIntro;

    public BookObject(String author) {
        this.author = author;
    }

    public BookObject() {
    }

    public BookObject(String author, String link, String name, String price, String linkIntro) {
        this.author = author;
        this.link = link;
        this.name = name;
        this.price = price;
        this.linkIntro = linkIntro;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setLinkIntro(String linkIntro) {
        this.linkIntro = linkIntro;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s" ,author, link, name, price, linkIntro);
    }
}
