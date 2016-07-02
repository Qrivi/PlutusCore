package be.plutus.core.repository;

import be.plutus.core.model.location.Campus;
import be.plutus.core.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

    Location findByName( String name );

    List<Location> findByCampus( Campus campus );
}
