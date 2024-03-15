package CiroVitiello.library_archive;

import java.util.Objects;

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


}
