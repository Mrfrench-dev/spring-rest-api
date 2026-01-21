package com.example.asfranca.spring_rest_api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "book") //Se for o mesmo do banco não precisa declarar igual aqui, somente ex
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
    private long id;

    @Column(name = "title", nullable = false, length = 80)
    private String title;

    @Column(name = "publisher", nullable = false, length = 80)
    private String publisher;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "price", nullable = false, length = 8)
    private Double price;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(publisher, book.publisher) && Objects.equals(author, book.author) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), publisher, author, price);
    }
}