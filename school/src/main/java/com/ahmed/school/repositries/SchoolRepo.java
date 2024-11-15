package com.ahmed.school.repositries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ahmed.school.entities.School;
import java.util.List;

@Repository
public interface SchoolRepo extends JpaRepository<School, Integer> {
    List<School> findAll();

    @SuppressWarnings("unchecked")
    School save(School School);
}
