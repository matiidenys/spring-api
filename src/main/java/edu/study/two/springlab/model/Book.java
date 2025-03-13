package edu.study.two.springlab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*
    @author  matiidenys
    @project  springlab
    @class  Book
    @version  1.0.0
    @since 2022.05.02 - 18:47
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    private String title;
    private int pages;
    private LocalDate releaseDate;
    private List<Author> authors;
    private Publisher publisher;
    private double priceUAH;
    private List<Genre> genres;
    private Cover cover;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
