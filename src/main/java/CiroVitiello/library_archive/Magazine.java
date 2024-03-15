package CiroVitiello.library_archive;

import CiroVitiello.enums.Periodicity;

public class Magazine extends LibraryArchive {

    //  ATTRIBUTES

    private Periodicity periodicity;

    // CONSTRUCTOR

    public Magazine(int ISBNcode, String title, int yearOfPublication, int pages, Periodicity periodicity) {
        super(ISBNcode, title, yearOfPublication, pages);
        this.periodicity = periodicity;
    }


    // METHODS


    @Override
    public String toString() {
        return "Magazines{" +
                "periodicity=" + periodicity +
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
        Magazine magazines = (Magazine) o;
        return periodicity == magazines.periodicity;
    }


}
