package artur.task1.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentRequestDTO {
    private String name;
    private String lastname;
    private Date dateOfBirth;  // Дата рождения
    private String faculty;
    private Long groupId;
}