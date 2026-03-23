package tn.esprit.mohamed_arous.entities;
import java.io.Serializable;
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
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCourse ;
    private int level;
    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse;
    @Enumerated(EnumType.STRING)
    private Support support;
    private Float price;
    private int timeSlot;


    @OneToMany(mappedBy = "course")
    private Set<Registration> registrations;

}