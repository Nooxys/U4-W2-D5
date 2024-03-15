package CiroVitiello.library_archive;

import java.util.Objects;

public abstract class LibraryArchive {

    //  ATTRIBUTES

    protected int ISBNcode;
    protected String Title;
    protected int yearOfPublication;

    protected int pages;

    // CONSTRUCTOR


    public LibraryArchive(int ISBNcode, String title, int yearOfPublication, int pages) {
        this.ISBNcode = ISBNcode;
        Title = title;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
    }


    // METHODS

    
    @Override
    public String toString() {
        return "LibraryArchive{" +
                "ISBNcode=" + ISBNcode +
                ", Title='" + Title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryArchive that = (LibraryArchive) o;
        return ISBNcode == that.ISBNcode && yearOfPublication == that.yearOfPublication && pages == that.pages && Objects.equals(Title, that.Title);
    }


}
