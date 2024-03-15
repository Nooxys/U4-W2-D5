package CiroVitiello.library_archive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    private static Logger logger = LoggerFactory.getLogger((Application.class));

    public static void main(String[] args) {

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
        archive.forEach(libraryArchive -> System.out.println(libraryArchive));


        LibraryArchive.addElement(archive);

    }


}
