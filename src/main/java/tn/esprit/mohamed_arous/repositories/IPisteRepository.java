package tn.esprit.mohamed_arous.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamed_arous.entities.Piste;

@Repository
public interface IPisteRepository extends JpaRepository<Piste,Long> {
}
