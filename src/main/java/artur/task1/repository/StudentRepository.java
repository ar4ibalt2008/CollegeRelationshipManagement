package artur.task1.repository;
import artur.task1.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Здесь можно добавить дополнительные методы для запросов, если необходимо
    Student findByLastname(String lastname);
}
