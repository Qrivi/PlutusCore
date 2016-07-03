package be.plutus.core.model.location;

import be.plutus.common.identifiable.Identifiable;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "location" )
public class Location extends Identifiable{

    @NotBlank( message = "{NotBlank.Location.name}" )
    @Column( name = "name" )
    private String name;

    @Column( name = "lat" )
    private double lat;

    @Column( name = "lng" )
    private double lng;

    @Valid
    @NotNull( message = "{NotNull.Location.campus}" )
    @ManyToOne
    @JoinColumn( name = "campus_id" )
    private Campus campus;

    public Location(){
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
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

    public Campus getCampus(){
        return campus;
    }

    public void setCampus( Campus campus ){
        this.campus = campus;
    }
}
