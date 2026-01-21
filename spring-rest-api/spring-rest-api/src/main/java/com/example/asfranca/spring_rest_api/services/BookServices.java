package com.example.asfranca.spring_rest_api.services;

/*import br.com.mrfrench_dev.data.dto.v1.PersonDTO;
import br.com.mrfrench_dev.data.dto.v2.PersonDTOv2;*/

import com.example.asfranca.spring_rest_api.exception.ResourceNotFoundException;
import com.example.asfranca.spring_rest_api.model.Book;
import com.example.asfranca.spring_rest_api.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

//import static br.com.mrfrench_dev.mapper.ObjectMapper.parseListObjects;
//import static br.com.mrfrench_dev.mapper.ObjectMapper.parseObject;

@Service //Indicates a Service Class
public class BookServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(BookServices.class.getName());

    @Autowired
    BookRepository repository;
/*
    @Autowired
    PersonMapper converter;*/

    public Book Create(Book book) {
        logger.info("Creating one person!");
        return repository.save(book);
/*
      var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity),PersonDTO.class);*/
    }

    //v2 create
/*
    public Bookv2 Createv2(Bookv2 bookv2) {
        logger.info("Creating one book V2!");

        var entity = converter.convertDTOToEntity(person);

        return converter.convertEntityoToDTO(repository.save(entity));
    }*/
    //Book Update, return the data with the new info
    public Book Update(Book book) {
        logger.info("Updating book!");

        Book bookUpdated = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found!"));


        bookUpdated.setTitle(book.getTitle());
        bookUpdated.setPublisher(book.getPublisher());
        bookUpdated.setAuthor(book.getAuthor());
        bookUpdated.setPrice(book.getPrice());

        return repository.save(bookUpdated);
       // return parseObject(repository.save(entity), PersonDTO.class);

    }

    public void Delete(Long id) {
        logger.info("Deleting person!");

       Book book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        repository.delete(book);
    }

    public Book findById(Long id) {
        logger.info("Finding one Book! ");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        /*
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        return parseObject(entity, PersonDTO.class);*/
    }

    public List<Book> findAll() {
        logger.info("Finding all Persons! ");
        return repository.findAll();
        //return parseListObjects(repository.findAll(),PersonDTO.class);

    }


}
