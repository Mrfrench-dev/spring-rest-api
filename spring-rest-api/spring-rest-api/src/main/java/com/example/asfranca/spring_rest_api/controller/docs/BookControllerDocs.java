package com.example.asfranca.spring_rest_api.controller.docs;

import com.example.asfranca.spring_rest_api.dto.BookRequestDTO;
import com.example.asfranca.spring_rest_api.dto.BookResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookControllerDocs {

    // ========================
    // FIND ALL
    // ========================
    @Operation(
            summary = "Find all books",
            description = "Returns a list of all registered books",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = BookResponseDTO.class)
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    List<BookResponseDTO> findAll();


    // ========================
    // FIND BY ID
    // ========================
    @Operation(
            summary = "Find a book by ID",
            description = "Returns a specific book based on its ID",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Book Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    BookResponseDTO findById(@PathVariable("id") Long id);


    // ========================
    // CREATE
    // ========================
    @Operation(
            summary = "Create a new book",
            description = "Creates and saves a new book",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    BookResponseDTO create(@RequestBody BookRequestDTO book);


    // ========================
    // UPDATE
    // ========================
    @Operation(
            summary = "Update a book",
            description = "Updates an existing book by ID",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = BookResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Book Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    BookResponseDTO update(
            @RequestBody BookRequestDTO book,
            @PathVariable("id") Long id
    );


    // ========================
    // DELETE
    // ========================
    @Operation(
            summary = "Delete a book",
            description = "Deletes a book based on its ID",
            tags = {"Books"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "404", description = "Book Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
