package com.example.asfranca.spring_rest_api.dto;

import java.util.Objects;

public class BookResponseDTO {

    private long id;
    private String publisher;
    private String author;
    private String title;
    private double price;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookResponseDTO bookRequestDTO)) return false;
        return getId() == bookRequestDTO.getId() && Objects.equals(publisher, bookRequestDTO.publisher) && Objects.equals(author, bookRequestDTO.author) && Objects.equals(title, bookRequestDTO.title) && Objects.equals(price, bookRequestDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), publisher, author, title, price);
    }
}
