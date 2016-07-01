package be.plutus.repository;

import be.plutus.core.location.Campus;
import be.plutus.core.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

    Location findByName( String name );
    List<Location> findByCampus( Campus campus );
}
