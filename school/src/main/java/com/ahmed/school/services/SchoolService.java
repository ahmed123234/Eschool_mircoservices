package com.ahmed.school.services;

import org.springframework.stereotype.Service;
import com.ahmed.school.repositries.SchoolRepo;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.ahmed.school.FullSchoolResponse;
import com.ahmed.school.entities.School;
import com.ahmed.school.client.StudentClient;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepo schoolRepo;
    private final StudentClient client;
    public List<School> findAllSchools() {
        return schoolRepo.findAll();
    }

    public School createNewSchool(School school) {
        return schoolRepo.save(school);
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepo.findById(schoolId)
        .orElse(
            School.builder()
            .name("NOT_FOUND")
            .email("NOT_FOUND")
            .build()
        );

        var students = client.findAllStudentsBySchool(schoolId); // find all the students from student micro-service
        return FullSchoolResponse
        .builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
    }
}
