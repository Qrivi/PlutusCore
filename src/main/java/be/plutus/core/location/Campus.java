package be.plutus.core.location;

import be.plutus.common.identifiable.Identifiable;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "campus" )
public class Campus extends Identifiable{

    @NotBlank( message = "{NotBlank.Campus.name}" )
    @Column( name = "name", unique = true )
    private String name;

    @Valid
    @NotNull( message = "{NotNull.Campus.Institution}" )
    @ManyToOne
    @JoinColumn( name = "institution_id" )
    private Institution institution;

    @Min( value = -90, message = "{Min.Campus.lat}" )
    @Max( value = 90, message = "{Max.Campus.lat}" )
    @Column( name = "lat" )
    private double lat;

    @Min( value = -180, message = "{Min.Campus.lon}" )
    @Max( value = 180, message = "{Max.Campus.lon}" )
    @Column( name = "lng" )
    private double lng;

    @NotBlank( message = "{NotBlank.Campus.address}" )
    @Column( name = "address" )
    private String address;

    @NotBlank( message = "{NotBlank.Campus.city}" )
    @Column( name = "city" )
    private String city;

    @NotNull( message = "{NotNull.Campus.zip}" )
    @Column( name = "zip" )
    private int zip;

    @NotBlank( message = "{NotBlank.Campus.country}" )
    @Column( name = "country" )
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
