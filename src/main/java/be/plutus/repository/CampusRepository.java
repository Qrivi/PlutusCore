package be.plutus.repository;

import be.plutus.core.location.Campus;
import be.plutus.core.location.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampusRepository extends JpaRepository<Campus, Integer>{

    Campus findByName( String name );
    List<Campus> findByInstitution( Institution institution );
}
