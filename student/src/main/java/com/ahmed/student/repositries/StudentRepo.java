package com.ahmed.student.repositries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ahmed.student.entities.Student;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findAll();

    @SuppressWarnings("unchecked")
    Student save(Student student);

    List<Student> findAllBySchoolId(Integer schoolId);
}
