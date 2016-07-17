package be.plutus.core.repository;

import be.plutus.core.model.location.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer>{

    Institution findBySlur( String slur );
}
