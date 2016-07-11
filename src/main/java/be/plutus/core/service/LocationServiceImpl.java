package be.plutus.core.service;

import be.plutus.core.model.location.Campus;
import be.plutus.core.model.location.Institution;
import be.plutus.core.model.location.Location;
import be.plutus.core.repository.CampusRepository;
import be.plutus.core.repository.InstitutionRepository;
import be.plutus.core.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    CampusRepository campusRepository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Institution> getAllInstitutions(){
        return institutionRepository.findAll();
    }

    @Override
    public Institution createInstitution( String name, String slur, String hint ){
        Institution institution = new Institution();
        institution.setName( name );
        institution.setSlur( slur );
        institution.setHint( hint );
        return institutionRepository.save( institution );
    }

    @Override
    public Campus getCampusByName( String name ){
        return campusRepository.findByName( name );
    }

    @Override
    public Campus createCampus( String name, Institution institution, double lat,double lng, String address, String zip, String city, String country ){
        Campus campus = new Campus();
        campus.setName( name );
        campus.setInstitution( institution );
        campus.setLat( lat );
        campus.setLng( lng );
        campus.setAddress( address );
        campus.setZip( zip );
        campus.setCity( city );
        campus.setCountry( country );
        return campusRepository.save( campus );
    }

    @Override
    public Location createLocation( String name, double lat, double lng, Campus campus ){
        Location location = new Location();
        location.setName( name );
        location.setLat( lat );
        location.setLng( lng );
        location.setCampus( campus );
        return locationRepository.save( location );
    }

    @Override
    public Location getLocationByName( String name ){
        return locationRepository.findByName( name );
    }

    public Location createLocation( String name, Campus campus ){
        Location location = new Location();
        location.setName( name );
        location.setCampus( campus );
        return locationRepository.save( location );
    }
}
