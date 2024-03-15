package CiroVitiello.library_archive;

import CiroVitiello.enums.Periodicity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    public static void addElement(List<LibraryArchive> element) {
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
                    element.add(0, new Book(code, title, year, pages, author, genre));
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
                    element.add(0, new Magazine(code, title, year, pages, periodicity));
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

    public static void removeElement(List<LibraryArchive> element) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("type 0 to close the application.");
            System.out.println("type 1 to remove an element by ISBN code.");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1: {
                    System.out.println("insert the ISBN code of the element you want to remove");
                    int code = Integer.parseInt(scanner.nextLine());
                    try {
                        LibraryArchive elementToRemove = element.stream().filter(libraryArchive -> libraryArchive.getISBNcode() == code).toList().get(0);
                        element.remove(elementToRemove);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.getMessage();
                    }
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

    public static void searchByCode(List<LibraryArchive> element) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("type 0 to close the application.");
            System.out.println("type 1 to search an element by ISBN code.");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1:
                    System.out.println("insert the ISBN code of the element you want to search");
                    int code = Integer.parseInt(scanner.nextLine());
                    try {
                        LibraryArchive elementToSearch = element.stream().filter(libraryArchive -> libraryArchive.getISBNcode() == code).toList().get(0);
                        System.out.println("you searched for: " + elementToSearch);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.getMessage();
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

    public static void searchByYear(List<LibraryArchive> element) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("type 0 to close the application.");
            System.out.println("type 1 to search an element by publication year.");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1: {
                    System.out.println("insert the year of the element you want to search");
                    int year = Integer.parseInt(scanner.nextLine());
                    try {
                        Map<Integer, List<LibraryArchive>> listByYear = element.stream().filter(libraryArchive -> libraryArchive.getYearOfPublication() == year).collect(Collectors.groupingBy(libraryArchive -> libraryArchive.getYearOfPublication()));
                        listByYear.forEach((integer, archives) -> System.out.println(archives));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.getMessage();

                    }
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

    public static void searchByAuthor(List<LibraryArchive> element) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("type 0 to close the application.");
            System.out.println("type 1 to search an element author.");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1: {
                    System.out.println("insert the author of the element you want to search");
                    String author = scanner.nextLine();
                    try {
                        Map<String, List<LibraryArchive>> listByAuthor = element.stream()
                                .filter(libraryArchive -> libraryArchive instanceof Book)
                                .filter(libraryArchive -> ((Book) libraryArchive).getAuthor().toLowerCase().equals(author))
                                .collect(Collectors.groupingBy(libraryArchive -> ((Book) libraryArchive).getAuthor().toLowerCase()));
                        listByAuthor.forEach((s, archives) -> System.out.println(s + archives));

                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.getMessage();

                    }
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

    public static void saveData(List<LibraryArchive> elements) {
        try {
            File file = new File("libraryArchive.txt");
            String data = "";
            for (LibraryArchive readable : elements) {
                if (readable instanceof Book) {
                    data += readable.getISBNcode() + "@" + readable.getTitle() + "@" + readable.getYearOfPublication() + "@" + readable.getPages() + "@" + ((Book) readable).getAuthor() + "@" + ((Book) readable).getGenre() + "#";
                } else if (readable instanceof Magazine) {
                    data += readable.getISBNcode() + "@" + readable.getTitle() + "@" + readable.getYearOfPublication() + "@" + readable.getPages() + "@" + ((Magazine) readable).getPeriodicity() + "#";
                }
                FileUtils.writeStringToFile(file, data, "UTF-8");
            }
        } catch (IOException ex) {
            System.err.println("failed to write");
        } catch (Exception ex) {
            System.err.println("generic error during writing");
        }
    }

    public static List<LibraryArchive> loadData() {
        List<LibraryArchive> loadedList = new ArrayList<>();
        try {
            File file = new File("libraryArchive.txt");
            String fileString = FileUtils.readFileToString(file, "UTF-8");
            List<String> splitted = Arrays.asList(fileString.split("#"));
            loadedList = splitted.stream().map(string -> {
                String[] obj = string.split("@");
                if (Arrays.asList(obj).size() == 6) {
                    return new Book(Integer.parseInt(obj[0]), obj[1], Integer.parseInt(obj[2]), Integer.parseInt(obj[3]), obj[4], obj[5]);
                } else {
                    return new Magazine(Integer.parseInt(obj[0]), obj[1], Integer.parseInt(obj[2]), Integer.parseInt(obj[3]), Periodicity.valueOf(obj[4]));
                }
            }).toList();
            

        } catch (IOException ex) {
            System.err.println("failed to load");
        } catch (Exception ex) {
            System.err.println("generic error during loading");
        }
        return loadedList;

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
