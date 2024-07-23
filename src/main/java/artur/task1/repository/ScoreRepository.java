package artur.task1.repository;
import artur.task1.entity.Score;
import artur.task1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    // Здесь можно добавить дополнительные методы для запросов, если необходимо
    List<Score> findAllByStudentId(Long studentId);
    List<Score> findAllBySubjectId(Long subjectId);
    List<Score> findAllByTeacherId(Long teacherId);
}
