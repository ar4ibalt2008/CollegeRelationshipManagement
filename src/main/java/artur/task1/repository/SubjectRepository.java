package artur.task1.repository;

import artur.task1.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    // Найти предмет по комнате
    Subject findByRoom(String room);  // Используйте маленькую букву 'r' для соответствия соглашению о наименовании
}
