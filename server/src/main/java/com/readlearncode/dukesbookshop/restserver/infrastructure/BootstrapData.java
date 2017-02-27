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

    private static final String IMAGE_LOCATION = "/images/covers/";

    @EJB
    private BookRepository bookRepository;

    @EJB
    private AuthorRepository authorRepository;

    @PostConstruct
    public void populateRepositories() {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Create the authors
        Author alex = authorRepository.saveAuthor(new Author("1", "Alex", "Theedom", "my blog 1"));
        Author murat = authorRepository.saveAuthor(new Author("2", "Murat", "Yener", "my blog 2"));
        Author onur = authorRepository.saveAuthor(new Author("3", "Onur", "Dundar", "my blog 3"));
        Author arun = authorRepository.saveAuthor(new Author("4", "Arun", "Gupta", "my blog 4"));
        Author adam = authorRepository.saveAuthor(new Author("5", "Adam", "Bien", "my blog 5"));

        try {


            // Create the books
            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("111884341X")
                            .setTitle("Professional Java EE Design Patterns")
                            .setDescription("Professional java ee design patterns is the perfect companion for anyone who wants to work more effectively with java ee, and the only resource that covers both the theory and application of design patterns in solving real-world problems.")
                            .setPrice(31.43f)
                            .setImageFileName(IMAGE_LOCATION + "java_ee_dp.jpg")
                            .addAuthor(alex)
                            .addAuthor(murat)
                            .setPublished(dateFormat.parse("04-03-2015"))
                            .setLink("https://www.amazon.com/Professional-Java-EE-Design-Patterns/dp/111884341X/")
                            .createBook());

            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1119089255")
                            .setTitle("Expert Andriod Studio")
                            .setDescription("Expert Android Studio bridges the gap between your Android programing skills with the provided tools including Android Studio, NDK, Gradle and Plugins for IntelliJ Idea Platform.")
                            .setPrice(28.57f)
                            .setImageFileName(IMAGE_LOCATION + "expert_andriod.jpg")
                            .addAuthor(murat)
                            .addAuthor(onur)
                            .setPublished(dateFormat.parse("25-08-2016"))
                            .setLink("https://www.amazon.com/Expert-Android-Studio-Murat-Yener/dp/1119089255/")
                            .createBook());

            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1449370179")
                            .setTitle("Java EE 7 Essentials: Enterprise Developer Handbook")
                            .setDescription("Get up to speed on the principal technologies in the Java Platform, Enterprise Edition 7, and learn how the latest version embraces HTML5, focuses on higher productivity, and provides functionality to meet enterprise demands.")
                            .setPrice(29.62f)
                            .setImageFileName(IMAGE_LOCATION + "java_ee_essentials.jpg")
                            .addAuthor(arun)
                            .setPublished(dateFormat.parse("09-08-2013"))
                            .setLink("https://www.amazon.com/Java-EE-Essentials-Enterprise-Developer/dp/1449370179/")
                            .createBook());

            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("143024626X")
                            .setTitle("Beginning Java EE 7")
                            .setDescription("Java Enterprise Edition (Java EE) continues to be one of the leading Java technologies and platforms. Beginning Java EE 7 is the first tutorial book on Java EE 7.")
                            .setPrice(24.42f)
                            .setImageFileName(IMAGE_LOCATION + "beginning_java_ee_7.jpg")
                            .addAuthor(arun)
                            .setPublished(dateFormat.parse("09-08-2013"))
                            .setLink("https://www.amazon.com/Beginning-Java-EE-Expert-Voice/dp/143024626X/")
                            .createBook());

            bookRepository.saveBook(
                    new BookBuilder()
                            .setId("1300149310")
                            .setTitle("Real World Java EE Patterns--Rethinking Best Practices")
                            .setDescription("Real World Java EE Pattern--Rethinking Best Practices discusses efficient patterns and best practices in a structured way, with code from real world projects.")
                            .setPrice(11.71f)
                            .setImageFileName(IMAGE_LOCATION + "real_world_java_ee_patterns.jpg")
                            .addAuthor(adam)
                            .setPublished(dateFormat.parse("31-10-2012"))
                            .setLink("https://www.amazon.com/Real-World-Java-Patterns-Rethinking-Practices/dp/1300149310/")
                            .createBook());

        } catch (ParseException e) {
            System.out.println("Exception thrown while bootstrapping. " + e);
        }

    }


}
