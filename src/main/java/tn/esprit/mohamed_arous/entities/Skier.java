package tn.esprit.mohamed_arous.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkier;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;

    @ManyToMany
    private Set<Piste> pistes;

    @OneToMany(mappedBy = "skier")
    private Set<Registration> registrations;

    @OneToOne
    private Subscription subscription;
}
