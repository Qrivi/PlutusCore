package be.plutus.core.service;

import be.plutus.core.model.location.Campus;
import be.plutus.core.model.location.Institution;
import be.plutus.core.model.location.Location;

import java.util.List;

public interface LocationService{

    List<Institution> getAllInstitutions();

    Institution getInstitutionBySlur( String slur );

    Institution createInstitution( String name, String slur, String hint );

    Campus getCampusByName( String name );

    Campus createCampus( String name, Institution institution, double lat,double lng, String address, String zip, String city, String country );

    Location createLocation( String name, double lat, double lng, Campus campus );

    Location getLocationByName( String name );

    Location createLocation( String name, Campus campus );
}
