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
        Author meek = authorRepository.saveAuthor(new Author("1", "Captain S. P.", "Meek", "http://www.gutenberg.org"));
        Author wright = authorRepository.saveAuthor(new Author("2", "Sewell", "Peaslee Wright", "http://www.gutenberg.org"));
        Author knight = authorRepository.saveAuthor(new Author("3", "Damon Francis", "Knight", "http://www.gutenberg.org"));
        Author dee = authorRepository.saveAuthor(new Author("4", "Roger", "Dee", "http://www.gutenberg.org"));
        Author sohl = authorRepository.saveAuthor(new Author("5", "Gerald Allan", "Sohl", "http://www.gutenberg.org"));
        Author harmon = authorRepository.saveAuthor(new Author("6", "Jim", "Harmon", "http://www.gutenberg.org"));
        Author fetlet = authorRepository.saveAuthor(new Author("7", "Andrew", "Fetler", "http://www.gutenberg.org"));
        Author leiber = authorRepository.saveAuthor(new Author("8", "Fritz", "Leiber", "http://www.gutenberg.org"));
        Author janis = authorRepository.saveAuthor(new Author("9", "Jean", "Janis", "http://www.gutenberg.org"));
        Author mayhem = authorRepository.saveAuthor(new Author("10", "Johnny", "Mayhem", "http://www.gutenberg.org"));
        Author savage = authorRepository.saveAuthor(new Author("11", "Arthur", "Savage", "http://www.gutenberg.org"));
        Author young = authorRepository.saveAuthor(new Author("12", "Robert", "Young", "http://www.gutenberg.org"));
        Author miller = authorRepository.saveAuthor(new Author("13", "R", "DeWitt Miller", "http://www.gutenberg.org"));
        Author stecher = authorRepository.saveAuthor(new Author("14", "L. J.", "Stecher JR.", "http://www.gutenberg.org"));
        Author stuart = authorRepository.saveAuthor(new Author("15", "William", "Stuart", "http://www.gutenberg.org"));
        Author leinster = authorRepository.saveAuthor(new Author("16", "Murray", "Leinster", "http://www.gutenberg.org"));
        Author ludwig = authorRepository.saveAuthor(new Author("17", "Edward", "Ludwig", "http://www.gutenberg.org"));


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


            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("4568744125")
                            .setTitle("Rough Translation")
                            .setDescription("Don't be ashamed if you can't blikkel any more. It's because you couldn't help framishing.")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "later_than_you_think.jpg")
                            .addAuthor(janis)
                            .setPublished(dateFormat.parse("05-06-1956"))
                            .setLink("https://www.gutenberg.org/ebooks/31980")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("4587874584")
                            .setTitle("The Animated Pinup")
                            .setDescription("To make it clear how normal everything was when the evening started out, I'll let you in at the time Willy phoned me.")
                            .setPrice(0.20f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_animated_pinup.jpg")
                            .addAuthor(janis)
                            .setPublished(dateFormat.parse("15-07-1953"))
                            .setLink("https://www.gutenberg.org/ebooks/32345")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1236985748")
                            .setTitle("World Beyond Pluto")
                            .setDescription("They loaded the over-age spaceship at night because Triton's one spaceport was too busy with the oreships from Neptune during the day to handle it.")
                            .setPrice(0.35f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_animated_pinup.jpg")
                            .addAuthor(mayhem)
                            .setPublished(dateFormat.parse("13-11-1958"))
                            .setLink("https://www.gutenberg.org/ebooks/32820")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("9689744589")
                            .setTitle("The Butterfly Kiss")
                            .setDescription("When Sykin Supcel was kidnaped, no one on Earth was less surprised than Dr. Horace Wilton, Chief Military Psychologist of the Solar Navy.")
                            .setPrice(0.35f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_butterfly_kiss.jpg")
                            .addAuthor(savage)
                            .setPublished(dateFormat.parse("25-12-1953"))
                            .setLink("https://www.gutenberg.org/ebooks/40991")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("5899871214")
                            .setTitle("Sweet Tooth")
                            .setDescription("The aliens were quite impressed by Earth's technical marvels—they found them just delicious!")
                            .setPrice(0.35f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "sweet_tooth.jpg")
                            .addAuthor(young)
                            .setPublished(dateFormat.parse("20-10-1963"))
                            .setLink("https://www.gutenberg.org/ebooks/50924")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1247985684")
                            .setTitle("Swenson, Dispatcher")
                            .setDescription("There were no vacuums in Space Regulations, so Swenson—well, you might say he knew how to plot courses through sub-ether legality!")
                            .setPrice(0.35f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "swenson_dispatcher.jpg")
                            .addAuthor(miller)
                            .setPublished(dateFormat.parse("14-04-1956"))
                            .setLink("https://www.gutenberg.org/ebooks/51331")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("7877896588")
                            .setTitle("Perfect Answer")
                            .setDescription("Getting there may be half the fun ... but it is also all of a society's chance of survival!")
                            .setPrice(0.35f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "perfect_answer.jpg")
                            .addAuthor(stecher)
                            .setPublished(dateFormat.parse("28-06-1958"))
                            .setLink("https://www.gutenberg.org/ebooks/51482")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("100255852X")
                            .setTitle("Kreativity For Kats")
                            .setDescription("They are the aliens among us—and their ways and wonders are stranger than extraterrestrials!")
                            .setPrice(0.50f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "kreativity_for_kats.jpg")
                            .addAuthor(leiber)
                            .setPublished(dateFormat.parse("28-04-1961"))
                            .setLink("https://www.gutenberg.org/ebooks/51493")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("5899858871")
                            .setTitle("The Little Man Who Wasn't Quite")
                            .setDescription("You could say Jonesy and/or I were not all there, but I don't see it that way. How much of Stanley was or wasn't there?")
                            .setPrice(0.50f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "the_little_man.jpg")
                            .addAuthor(stuart)
                            .setPublished(dateFormat.parse("08-12-1961"))
                            .setLink("https://www.gutenberg.org/ebooks/51698")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1112588089")
                            .setTitle("Third Planet")
                            .setDescription("The aliens had lost their lives to nuclear war—but their loss might be the salvation of Earth!")
                            .setPrice(0.50f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "third_planet.jpg")
                            .addAuthor(leinster)
                            .setPublished(dateFormat.parse("08-04-1963"))
                            .setLink("https://www.gutenberg.org/ebooks/52574")
                            .createBook());

            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("5500898544")
                            .setTitle("To Save Earth")
                            .setDescription("The life of everyone on Earth depended on hich they had long ago lost!")
                            .setPrice(0.50f)
                            .setImageFileName(API_URL + IMAGE_LOCATION + "to_save_earth.jpg")
                            .addAuthor(ludwig)
                            .setPublished(dateFormat.parse("08-10-1963"))
                            .setLink("https://www.gutenberg.org/ebooks/53059")
                            .createBook());


        } catch (ParseException e) {
            System.out.println("Exception thrown while bootstrapping. " + e);
        }

    }


}