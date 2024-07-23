package artur.task1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "scores")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer score;  // Оценка

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject; // Предмет

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher; // Преподаватель

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;  // Студент
}
