package artur.task1.repository;
import artur.task1.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Здесь можно добавить дополнительные методы для запросов, если необходимо
    Teacher findByLastName(String lastName);
}
