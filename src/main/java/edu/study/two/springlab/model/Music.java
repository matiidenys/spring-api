package edu.study.two.springlab.model;

/*
    @author  matiidenys
    @project  springlab
    @class  BookshelfItem
    @version  1.0.0
    @since 2024.05.17 - 18:53
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "music")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    private String id;
    private String name;

    private Binary data;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Music(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music that = (Music) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
