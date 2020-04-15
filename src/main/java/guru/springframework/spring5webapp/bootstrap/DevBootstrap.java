package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        intiData();
    }

    public void intiData(){
        Author andrew = new Author("Andrew" , "Shah");
        Publisher macGrew = new Publisher("MacGrew Hill" , "New Town , Banglore");
        Book inp = new Book("Introduction to programming" , "22342" , macGrew);
        andrew.getBooks().add(inp);
        inp.getAuthors().add(andrew);

        publisherRepository.save(macGrew);
        authorRepository.save(andrew);
        bookRepository.save(inp);

        Author michel = new Author("Michel" , "Cap");
        Publisher disneyEntertainment = new Publisher("Disney Entertainment" , "London");
        Book mcu = new Book("Marvel Comic Universe" , "3343" , disneyEntertainment);
        michel.getBooks().add(mcu);

        publisherRepository.save(disneyEntertainment);
        authorRepository.save(michel);
        bookRepository.save(mcu);

    }
}
