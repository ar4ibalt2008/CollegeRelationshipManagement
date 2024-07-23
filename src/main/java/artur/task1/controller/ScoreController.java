package artur.task1.controller;

import artur.task1.entity.Score;
import artur.task1.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreRepository.save(score);
    }

    @PutMapping("/{id}")
    public Score updateScore(@PathVariable Long id, @RequestBody Score score) {
        if (!scoreRepository.existsById(id)) {
            return null;
        }
        score.setId(id);
        return scoreRepository.save(score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreRepository.deleteById(id);
    }

    // Дополнительные методы для запросов, если необходимо
    // Например, получение оценок для конкретного студента
    @GetMapping("/student/{studentId}")
    public List<Score> getScoresByStudentId(@PathVariable Long studentId) {
        return scoreRepository.findAllByStudentId(studentId);
    }

    // Получение оценок по предмету
    @GetMapping("/subject/{subjectId}")
    public List<Score> getScoresBySubjectId(@PathVariable Long subjectId) {
        return scoreRepository.findAllBySubjectId(subjectId);
    }

    // Получение оценок по преподавателю
    @GetMapping("/teacher/{teacherId}")
    public List<Score> getScoresByTeacherId(@PathVariable Long teacherId) {
        return scoreRepository.findAllByTeacherId(teacherId);
    }
}
