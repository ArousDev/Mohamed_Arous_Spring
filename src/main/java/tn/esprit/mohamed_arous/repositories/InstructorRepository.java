package tn.esprit.mohamed_arous.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamed_arous.entities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
