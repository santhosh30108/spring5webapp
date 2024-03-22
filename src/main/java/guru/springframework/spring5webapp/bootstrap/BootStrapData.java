package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Component Started ------------>");

        Publisher bookpublisher = new Publisher();
        bookpublisher.setName("Book publisher");
        bookpublisher.setAddressLne1("Some Address");
        bookpublisher.setState("Karnataka");
        bookpublisher.setCity("Bangalore");
        bookpublisher.setZip("560092");

        publisherRepository.save(bookpublisher);


        Author santhosh = new Author("Santhosh","Kumar");
        Book hello_world = new Book("Hello World","2837012");

        santhosh.getBooks().add(hello_world);
        hello_world.getAuthors().add(santhosh);

        hello_world.setPublisher(bookpublisher);
        bookpublisher.getBooks().add(hello_world);

        authorRepository.save(santhosh);
        bookRepository.save(hello_world);

        Author moqtiar = new Author("Moqtiar","MR");
        Book hello_world2 = new Book("Hello World 2","2837032");

        moqtiar.getBooks().add(hello_world2);
        hello_world2.getAuthors().add(moqtiar);

        hello_world2.setPublisher(bookpublisher);
        bookpublisher.getBooks().add(hello_world2);

        authorRepository.save(moqtiar);
        bookRepository.save(hello_world2);

        System.out.println("No of publishers : "+publisherRepository.count());
        System.out.println("No of Authors : "+authorRepository.count());
        System.out.println("No of Books : "+bookRepository.count());
        System.out.println("No of Books a publisher has : "+bookpublisher.getBooks().size());
    }
}
