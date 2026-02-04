package com.example.asfranca.spring_rest_api.controller;

/*import br.com.mrfrench_dev.data.dto.v1.PersonDTO;
import br.com.mrfrench_dev.data.dto.v2.PersonDTOv2;
import br.com.mrfrench_dev.services.PersonServices;*/

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import com.example.asfranca.spring_rest_api.model.Book;
import com.example.asfranca.spring_rest_api.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//Indicates a RESTful controller Http > Json,Xml etc
@RestController
@RequestMapping("/api/book") //User for to map HTTPRequests
public class BookController {

    @Autowired //Inject dependencies
    private BookServices service;
    //Same as private PersonServices service = new PersonServices();

    //Create "version 1 in case of production other versions
    @PostMapping(value = "/v1",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE, //Value structure accepted/presented
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    //RequestBody collect the "body" data field on Postman
    public BookResponseDTO create(@RequestBody BookRequestDTO dto) {

        return service.create(dto);
    }

    //Select all books
    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})

    public List<BookResponseDTO> findAll() {

        return service.findAll();
    }


    //Select by ID
    @GetMapping(value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )

    public BookResponseDTO findById(@PathVariable("id") Long id) {

        return service.findById(id);
    }


    //Update
    @PutMapping(value = "/{id}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )

    public BookResponseDTO update(
            @RequestBody BookRequestDTO bookdto,
            @PathVariable Long id) {

        return service.Update(bookdto,id);
    }

    //Delete by id
    @DeleteMapping(value = "/{id}")

    //Returns the correct code for Delete (204 No Content)
    public ResponseEntity<?> Delete(@PathVariable("id") Long id) {
        service.Delete(id);
        return ResponseEntity.noContent().build();
    }

}