package edu.study.two.springlab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/*
    @author  matiidenys
    @project  springlab
    @class  Author
    @version  1.0.0
    @since 2022.05.02 - 18:53
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private String id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private LocalDate birthdate;
    private Gender gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Author(String id, String firstName, String secondName, String patronymic, LocalDate birthdate, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
