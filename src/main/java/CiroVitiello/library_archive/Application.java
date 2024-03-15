package CiroVitiello.library_archive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Application {
    private static Logger logger = LoggerFactory.getLogger((Application.class));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
//        Supplier<Book> bookSupplier = Book.booksSupplier();
//        List<Book> bookList = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            bookList.add(bookSupplier.get());
//        }
//        bookList.forEach(book -> logger.info(String.valueOf(book)));
//
//
//        Supplier<Magazine> magazineSupplier = Magazine.magazineSupplier();
//        List<Magazine> magazineList = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            magazineList.add(magazineSupplier.get());
//        }
//        magazineList.forEach(magazine -> logger.info(String.valueOf(magazine)));

        List<LibraryArchive> archive = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (random.nextInt(0, 2) < 1) {
                archive.add(Book.booksSupplier().get());
            } else archive.add(Magazine.magazineSupplier().get());
        }
//

        // APPLICATION

        int value;
        do {
            System.out.println("Starting program..");
            System.out.println("Press 0 to close the program!");
            System.out.println("Press 1 to add an element!");
            System.out.println("Press 2 to remove an element!");
            System.out.println("Press 3 to search an element by IBSN code!");
            System.out.println("Press 4 to search an element by publication year!");
            System.out.println("Press 5 to search an element by author");
            System.out.println("Press 6 to save the data on disk");
            System.out.println("Press 7 to load from the disk!");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1:
                    LibraryArchive.addElement(archive);
                    break;
                case 2:
                    LibraryArchive.removeElement(archive);
                    break;
                case 3:
                    LibraryArchive.searchByCode(archive);
                    break;
                case 4:
                    LibraryArchive.searchByYear(archive);
                    break;
                case 5:
                    LibraryArchive.searchByAuthor(archive);
                    break;
                case 6:
                    LibraryArchive.saveData(archive);
                    break;
                case 7:
                    LibraryArchive.loadData().forEach(libraryArchive -> logger.info(String.valueOf(libraryArchive)));
                    break;

                case 0:
                    System.out.println("closing program..");
                    scanner.close();
                    break;
                default:
                    logger.error("error! insert the correct value!");

            }
        } while (value != 0);
    }


}
