package com.readlearncode.dukesbookshop.restserver.infrastructure;

import com.readlearncode.dukesbookshop.restserver.domain.Author;
import com.readlearncode.dukesbookshop.restserver.domain.BookBuilder;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Singleton
@Startup
public class BootstrapData {

    private static final String API_URL = "http://localhost:8081/rest-server";
    private static final String IMAGE_LOCATION = "/images/covers/";

    @EJB
    private BookRepository bookRepository;

    @EJB
    private AuthorRepository authorRepository;

    @PostConstruct
    public void populateRepositories() {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Create the authors
        Author meek = authorRepository.saveAuthor(new Author("1", "Captain S. P.", "Meek", "www.gutenberg.org"));
        Author wright = authorRepository.saveAuthor(new Author("2", "Sewell", "Peaslee Wright", "www.gutenberg.org"));
        Author knight = authorRepository.saveAuthor(new Author("3", "Damon Francis", "Knight", "www.gutenberg.org"));
        Author dee = authorRepository.saveAuthor(new Author("4", "Roger", "Dee", "www.gutenberg.org"));
        Author sohl = authorRepository.saveAuthor(new Author("5", "Gerald Allan", "Sohl", "www.gutenberg.org"));
        Author harmon = authorRepository.saveAuthor(new Author("6", "Jim", "Harmon", "www.gutenberg.org"));
        Author fetlet = authorRepository.saveAuthor(new Author("7", "Andrew", "Fetler", "www.gutenberg.org"));
        Author leiber = authorRepository.saveAuthor(new Author("8", "Fritz", "Leiber", "www.gutenberg.org"));

        try {


            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1239875824")
                            .setTitle("The Thief of Time")
                            .setDescription("HARVEY WINSTON, paying teller of the First National Bank of Chicago, stripped the band from a bundle of twenty dollar bills, counted out seventeen of them and added them to the pile on the counter before him.")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_thief_of_time.jpg")
                            .addAuthor(meek)
                            .addAuthor(fetlet)
                            .setPublished(dateFormat.parse("01-02-1930"))
                            .setLink("https://www.gutenberg.org/ebooks/28617")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("6983458724")
                            .setTitle("Astounding Stories of Super Science")
                            .setDescription("Commander John Hanson relates an interplanetary adventure illustrating the splendid Service spirit of the men of the Special Patrol.")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "astounding_stories_of_super_science.jpg")
                            .addAuthor(wright)
                            .setPublished(dateFormat.parse("04-01-1931"))
                            .setLink("https://www.gutenberg.org/ebooks/30177")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("588968547X")
                            .setTitle("Special Delivery")
                            .setDescription("All Len had to hear was the old gag: \"We've never lost a father yet.\" His child was not even born and it was thoroughly unbearable!")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "special_delivery.jpg")
                            .addAuthor(knight)
                            .setPublished(dateFormat.parse("05-04-1954"))
                            .setLink("https://www.gutenberg.org/ebooks/32011")
                            .createBook());


            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("6958628754")
                            .setTitle("Clean Break")
                            .setDescription("A veteran veterinarian might have vamoosed—but Watts had to help any sick animal....!")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "clean_break.jpg")
                            .addAuthor(dee)
                            .setPublished(dateFormat.parse("10-11-1953"))
                            .setLink("https://www.gutenberg.org/ebooks/32212")
                            .createBook());


            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1159638459")
                            .setTitle("The Seventh Order")
                            .setDescription("A veteran veterinarian might have vamoosed—but Watts had to help any sick animal....!")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_seventh_order.jpg")
                            .addAuthor(sohl)
                            .setPublished(dateFormat.parse("16-03-1952"))
                            .setLink("https://www.gutenberg.org/ebooks/32327")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("2526987585")
                            .setTitle("Pet Farm")
                            .setDescription("The next worst thing to hell is being shanghaied into the Paradise of an alien planet!")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "pet_farm.jpg")
                            .addAuthor(dee)
                            .setPublished(dateFormat.parse("23-02-1954"))
                            .setLink("https://www.gutenberg.org/ebooks/32344")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("569835759X")
                            .setTitle("The Place Where Chicago Was")
                            .setDescription("Well, they finally got rid of war. For the first time there was peace on Earth—since the only possible victims were the killers themselves!")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_place_where_chicago_was.jpg")
                            .addAuthor(harmon)
                            .setPublished(dateFormat.parse("04-02-1962"))
                            .setLink("https://www.gutenberg.org/ebooks/51832")
                            .createBook());
            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("6986975426")
                            .setTitle("Cry Snooker")
                            .setDescription("At the breakfast table next morning George gave her the diamond cocktail ring she'd drooled over. Rosy gave him the self-winding time piece he'd slobbered over in Cellini's window.")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "cry_snooker.jpg")
                            .addAuthor(fetlet)
                            .setPublished(dateFormat.parse("12-10-1960"))
                            .setLink("https://www.gutenberg.org/ebooks/51570")
                            .createBook());


            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("8879585785")
                            .setTitle("Later Than You Think")
                            .setDescription("It's much later. The question is ... how late?")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "later_than_you_think.jpg")
                            .addAuthor(leiber)
                            .setPublished(dateFormat.parse("10-10-1950"))
                            .setLink("https://www.gutenberg.org/ebooks/50753")
                            .createBook());


        } catch (ParseException e) {
            System.out.println("Exception thrown while bootstrapping. " + e);
        }

    }


}
