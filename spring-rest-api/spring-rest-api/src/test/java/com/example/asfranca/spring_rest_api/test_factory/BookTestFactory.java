package com.example.asfranca.spring_rest_api.test_factory;

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import com.example.asfranca.spring_rest_api.model.Book;

public class BookTestFactory {

    public static Book mockEntity() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("Robert C. Martin");
        book.setTitle("Clean Code");
        book.setPrice(120.0);
        book.setPublisher("Prentice Hall");
        return book;
    }

    public static BookRequestDTO mockRequest() {
        BookRequestDTO request = new BookRequestDTO();
        request.setAuthor("Robert C. Martin");
        request.setTitle("Clean Code");
        request.setPrice(120.0);
        request.setPublisher("Prentice Hall");
        return request;
    }

    public static BookResponseDTO mockResponse() {
        BookResponseDTO response = new BookResponseDTO();
        response.setId(1L);
        response.setAuthor("Robert C. Martin");
        response.setTitle("Clean Code");
        response.setPrice(120.0);
        response.setPublisher("Prentice Hall");
        return response;
    }
}


