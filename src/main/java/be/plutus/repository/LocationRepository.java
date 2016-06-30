package be.plutus.repository;

import be.plutus.core.location.Campus;
import be.plutus.core.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer>{

    Location findByName( String name );
    List<Location> findByCampus( Campus campus );
}
