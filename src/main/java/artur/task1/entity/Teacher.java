package artur.task1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "teachers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;  // Имя

    @Column(name = "last_name")
    private String lastName;  // Фамилия

    @Column (name = "date_of_birth")
    private Date dateOfBirth;  // Дата рождения

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;  // Предмет
}
