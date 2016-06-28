package be.plutus.core.location;

import be.plutus.core.location.Institution;

public class Campus{

    private String name;
    private Institution institution;

    private double lat;
    private double lng;

    private String address;
    private int zip;
    private String city;
    private String country;

    public Campus(){

    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public Institution getInstitution(){
        return institution;
    }

    public void setInstitution( Institution institution ){
        this.institution = institution;
    }

    public double getLat(){
        return lat;
    }

    public void setLat( double lat ){
        this.lat = lat;
    }

    public double getLng(){
        return lng;
    }

    public void setLng( double lng ){
        this.lng = lng;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress( String address ){
        this.address = address;
    }

    public int getZip(){
        return zip;
    }

    public void setZip( int zip ){
        this.zip = zip;
    }

    public String getCity(){
        return city;
    }

    public void setCity( String city ){
        this.city = city;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry( String country ){
        this.country = country;
    }
}
