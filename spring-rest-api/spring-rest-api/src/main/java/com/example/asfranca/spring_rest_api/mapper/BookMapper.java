package com.example.asfranca.spring_rest_api.mapper;

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import com.example.asfranca.spring_rest_api.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface BookMapper {

    @Mapping(target = "id",ignore = true)

    Book toEntity(BookRequestDTO dto);
    BookResponseDTO toResponseDTO(Book book);
    List<BookResponseDTO> toDtoList(List<Book> entities);
}
