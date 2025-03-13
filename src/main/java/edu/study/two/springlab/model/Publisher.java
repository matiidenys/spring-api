package edu.study.two.springlab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

/*
    @author  matiidenys
    @project  springlab
    @class  Publisher
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    private String id;
    private String title;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id.equals(publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
