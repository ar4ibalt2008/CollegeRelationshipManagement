package artur.task1.controller;

import artur.task1.entity.Student;
import artur.task1.model.StudentRequestDTO;
import artur.task1.repository.GroupRepository;
import artur.task1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRequestDTO studentRequest) {
        return studentRepository.save(Student.builder()
                        .dateOfBirth(studentRequest.getDateOfBirth())
                        .faculty(studentRequest.getFaculty())
                        .name(studentRequest.getName())
                        .lastname(studentRequest.getLastname())
                        .group(groupRepository.findById(studentRequest.getGroupId()).orElseThrow())
                .build());
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        if (!studentRepository.existsById(id)) {
            return null;
        }
        student.setId(id);
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/lastname/{lastname}")
    public Student getStudentByLastname(@PathVariable String lastname) {
        return studentRepository.findByLastname(lastname);
    }
}
