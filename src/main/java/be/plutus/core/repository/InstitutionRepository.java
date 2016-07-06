package be.plutus.core.repository;

import be.plutus.core.model.location.Campus;
import be.plutus.core.model.location.Institution;
import be.plutus.core.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer>{
}
