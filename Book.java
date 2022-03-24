
public class Book {
    String bookName;
    String bookAuthor;
    int bookYear;
    public Book(String name, String author, int year) {
        bookName = name;
        bookAuthor = author;
        bookYear = year;
    }

    public String getDescription() {
        return this.bookName + " écrit par " + this.bookAuthor + " est paru en " + this.bookYear + ".";
    }
}
