package com.example.asfranca.spring_rest_api.services;

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import com.example.asfranca.spring_rest_api.exception.ResourceNotFoundException;
import com.example.asfranca.spring_rest_api.mapper.BookMapper;
import com.example.asfranca.spring_rest_api.model.Book;
import com.example.asfranca.spring_rest_api.repository.BookRepository;
import com.example.asfranca.spring_rest_api.test_factory.BookTestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServicesTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookServices service;

    @Mock
    private BookMapper mapper;

    @BeforeEach
    void setUp() {
    }


    @Test
    void create() {


        BookRequestDTO request = BookTestFactory.mockRequest();
        Book entity = BookTestFactory.mockEntity();
        Book savedEntity = BookTestFactory.mockEntity();
        BookResponseDTO response = BookTestFactory.mockResponse();

        when(mapper.toEntity(request)).thenReturn(entity);
        when(repository.save(Mockito.any(Book.class)))
                .thenReturn(savedEntity);
        when(mapper.toResponseDTO(savedEntity)).thenReturn(response);

        BookResponseDTO result = service.create(request);

        assertNotNull(result);
        assertEquals(response.getTitle(), result.getTitle());

        verify(repository).save(entity);
        verify(mapper).toEntity(request);
        verify(mapper).toResponseDTO(savedEntity);

    }

    @Test
    void findById() {
        Long id = 1L;
        Book entity = BookTestFactory.mockEntity();
        BookResponseDTO response = BookTestFactory.mockResponse();

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toResponseDTO(entity)).thenReturn(response);

        BookResponseDTO result = service.findById(id);

        assertNotNull(result);
        verify(repository).findById(id);
        verify(mapper).toResponseDTO(entity);
    }

    @Test
    void update() {
        Long id = 1L;
        BookRequestDTO request = BookTestFactory.mockRequest();
        Book existing = BookTestFactory.mockEntity();
        Book saved = BookTestFactory.mockEntity();
        BookResponseDTO response = BookTestFactory.mockResponse();

        when(repository.findById(id)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(saved);
        when(mapper.toResponseDTO(saved)).thenReturn(response);

        // Act
        BookResponseDTO result = service.Update(request, id);

        // Assert
        assertNotNull(result);
        verify(repository).findById(id);
        verify(repository).save(existing);
    }

    @Test
    void delete() {
        Long id = 1L;
        Book entity = BookTestFactory.mockEntity();

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        service.Delete(id);

        verify(repository).findById(id);
        verify(repository).delete(entity);
    }

    @Test
    void findAll() {
        List<Book> entities = List.of(
                BookTestFactory.mockEntity(),
                BookTestFactory.mockEntity()
        );

        List<BookResponseDTO> responses = List.of(
                BookTestFactory.mockResponse(),
                BookTestFactory.mockResponse()
        );

        when(repository.findAll()).thenReturn(entities);
        when(mapper.toDtoList(entities)).thenReturn(responses);

        List<BookResponseDTO> result = service.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());

        verify(repository).findAll();
        verify(mapper).toDtoList(entities);
    }
}