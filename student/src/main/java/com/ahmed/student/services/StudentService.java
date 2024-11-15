package com.ahmed.student.services;

import org.springframework.stereotype.Service;
import com.ahmed.student.repositries.StudentRepo;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ahmed.student.entities.Student;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public void createNewStudent(Student student) {
        studentRepo.save(student);
    }
    
    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepo.findAllBySchoolId(schoolId);
    }
}
