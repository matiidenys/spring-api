package edu.study.two.springlab.model;

/*
    @author  matiidenys
    @project  springlab
    @class  BookshelfItem
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookshelfItem {
    @Id
    private String id;
    private String row;
    private String bookshelfNumber;
    private int itemNumber;
    private Book book;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookshelfItem that = (BookshelfItem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
