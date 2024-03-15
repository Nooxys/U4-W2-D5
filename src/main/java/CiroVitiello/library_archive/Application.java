package CiroVitiello.library_archive;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static Logger logger = LoggerFactory.getLogger((Application.class));

    public static void main(String[] args) {

        Faker faker = new Faker();

        // SUPPLIERS

        Supplier<Book> booksSupplier = () -> {
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
}
