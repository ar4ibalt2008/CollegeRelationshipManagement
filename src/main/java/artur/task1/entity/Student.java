package artur.task1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column (name = "date_of_birth")
    private Date dateOfBirth;  // Дата рождения
    @Column
    private String faculty;
    @OneToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
}
