package artur.task1.repository;
import artur.task1.entity.Group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    // Здесь можно добавить дополнительные методы для запросов, если необходимо
    Group findByTitle(String title);
}
