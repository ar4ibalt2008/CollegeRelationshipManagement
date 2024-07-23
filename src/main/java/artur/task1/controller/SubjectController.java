package artur.task1.controller;

import artur.task1.entity.Subject;
import artur.task1.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        if (!subjectRepository.existsById(id)) {
            return null;
        }
        subject.setId(id);
        return subjectRepository.save(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }

    @GetMapping("/room/{room}")
    public Subject getSubjectByRoom(@PathVariable String room) {
        return subjectRepository.findByRoom(room);
    }
}
