package com.example.asfranca.spring_rest_api.mapper;

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import com.example.asfranca.spring_rest_api.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-12T12:47:11-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( dto.getTitle() );
        book.setPrice( dto.getPrice() );
        book.setPublisher( dto.getPublisher() );
        book.setAuthor( dto.getAuthor() );

        return book;
    }

    @Override
    public BookResponseDTO toResponseDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setTitle( book.getTitle() );
        bookResponseDTO.setPublisher( book.getPublisher() );
        bookResponseDTO.setAuthor( book.getAuthor() );
        bookResponseDTO.setPrice( book.getPrice() );
        bookResponseDTO.setId( book.getId() );

        return bookResponseDTO;
    }

    @Override
    public List<BookResponseDTO> toDtoList(List<Book> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BookResponseDTO> list = new ArrayList<BookResponseDTO>( entities.size() );
        for ( Book book : entities ) {
            list.add( toResponseDTO( book ) );
        }

        return list;
    }
}
