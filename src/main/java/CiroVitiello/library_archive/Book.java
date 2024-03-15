package CiroVitiello.library_archive;

import com.github.javafaker.Faker;

import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

public class Book extends LibraryArchive {

    // ATTRIBUTES

    private String author;


    private String genre;

    // CONSTRUCTOR
    public Book(int ISBNcode, String title, int yearOfPublication, int pages, String author, String genre) {
        super(ISBNcode, title, yearOfPublication, pages);
        this.author = author;
        this.genre = genre;
    }


    //  SUPPLIER

    public static Supplier<Book> booksSupplier() {

        return () -> {
            Faker faker = new Faker();
            Random random = new Random();
            int code = random.nextInt(1, 500);
            String title = faker.book().title();
            int releaseDate = random.nextInt(1960, 2024);
            int pages = random.nextInt(50, 300);
            String author = faker.book().author();
            String genre = faker.book().genre();

            return new Book(code, title, releaseDate, pages, author, genre);
        };
    }


    // METHODS


    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", ISBNcode=" + ISBNcode +
                ", Title='" + Title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book books = (Book) o;
        return Objects.equals(author, books.author) && Objects.equals(genre, books.genre);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
