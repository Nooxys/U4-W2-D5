package CiroVitiello.library_archive;

import CiroVitiello.enums.Periodicity;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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

    public static void addElement(List<LibraryArchive> elements) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("type 0 to close the application.");
            System.out.println("type 1 to add a book.");
            System.out.println("type 2 to add a magazine.");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1: {
                    System.out.println("Book selected! enter the ISBN code as number now!");
                    int code = Integer.parseInt(scanner.nextLine());
                    System.out.println("Great! now insert the title for your book!");
                    String title = scanner.nextLine();
                    System.out.println("OK! now insert the year the book was published");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("how many pages your book has? enter the number!");
                    int pages = Integer.parseInt(scanner.nextLine());
                    System.out.println("perfect! now enter the author of the book!");
                    String author = scanner.nextLine();
                    System.out.println(".. and the genre, of course!");
                    String genre = scanner.nextLine();
                    elements.add(0, new Book(code, title, year, pages, author, genre));
                    System.out.println("Book created!");
                    break;
                }
                case 2: {
                    System.out.println("Magazine selected! enter the ISBN code as number now!");
                    int code = Integer.parseInt(scanner.nextLine());
                    System.out.println("Great! now insert the title for your magazine!");
                    String title = scanner.nextLine();
                    System.out.println("OK! now insert the year the book was published");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("how many pages your magazine has? enter the number!");
                    int pages = Integer.parseInt(scanner.nextLine());
                    System.out.println("Select the periodicity of your magazine");
                    System.out.println("press 1 to insert WEEKLY");
                    System.out.println("press 2 to insert MONTHLY");
                    System.out.println("press 1 to insert HALF_YEARLY");
                    int periodicitySelector = Integer.parseInt(scanner.nextLine());
                    Periodicity[] periodicities = Periodicity.values();
                    Periodicity periodicity = periodicities[periodicitySelector - 1];
                    elements.add(0, new Magazine(code, title, year, pages, periodicity));
                    System.out.println("Magazine created!");
                    break;
                }
                case 0: {
                    System.out.println("closing application..");
                    scanner.close();
                    break;
                }
                default: {
                    System.err.println("Try again! Insert a correct value! ");
                }
            }

        } while (value != 0);

    }

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

    public int getISBNcode() {
        return ISBNcode;
    }

    public String getTitle() {
        return Title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getPages() {
        return pages;
    }
}
