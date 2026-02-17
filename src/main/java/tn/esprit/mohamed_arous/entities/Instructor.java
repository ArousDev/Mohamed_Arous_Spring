package tn.esprit.mohamed_arous.entities;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.mohamed_arous.entities.Course;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numinstructor;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private LocalDate dateofHire;

    @OneToMany
    private Set<Course> courses;
}
