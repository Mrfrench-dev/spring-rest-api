package com.example.asfranca.spring_rest_api.services;

/*import br.com.mrfrench_dev.data.dto.v1.PersonDTO;
import br.com.mrfrench_dev.data.dto.v2.PersonDTOv2;*/

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import com.example.asfranca.spring_rest_api.exception.ResourceNotFoundException;
import com.example.asfranca.spring_rest_api.mapper.BookMapper;
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

    //04/02 implementado o MapStruct
    @Autowired
    BookMapper mapper;

    public BookResponseDTO create(BookRequestDTO dto) {
        logger.info("Creating one book!");

        Book entity = mapper.toEntity(dto);
        Book saved =  repository.save(entity);

        return mapper.toResponseDTO(saved);
    }


    //Book Update, return the data with the new info
    public BookResponseDTO Update(BookRequestDTO dto, Long id) {
        logger.info("Updating book!");

        Book bookUpdated = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found!"));


        bookUpdated.setTitle(dto.getTitle());
        bookUpdated.setPublisher(dto.getPublisher());
        bookUpdated.setAuthor(dto.getAuthor());
        bookUpdated.setPrice(dto.getPrice());

        return mapper.toResponseDTO(repository.save(bookUpdated));

    }

    public void Delete(Long id) {
        logger.info("Deleting person!");

        Book book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        repository.delete(book);
    }

    public BookResponseDTO findById(Long id) {
        logger.info("Finding one Book! ");

        Book book =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));
        return mapper.toResponseDTO(book);
    }

    public List<BookResponseDTO> findAll() {
        logger.info("Finding all Persons! ");
        return mapper.toDtoList(repository.findAll());
    }


}
