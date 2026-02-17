package tn.esprit.mohamed_arous.entities;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.mohamed_arous.entities.Registration;
import tn.esprit.mohamed_arous.entities.TypeCourse;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCourse ;
    private int level;
    private TypeCourse typeCourse;
    private Float price;
    private int timeSlot;


    @OneToMany(mappedBy = "course")
    private Set<Registration> registrations;

}