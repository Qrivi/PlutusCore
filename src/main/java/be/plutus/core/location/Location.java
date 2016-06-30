package be.plutus.core.location;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="location")
public class Location{

    @NotBlank( message = "{NotBlank.Location.name}" )
    @Column( name = "name" )
    private String name;

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

    public Campus getCampus(){
        return campus;
    }

    public void setCampus( Campus campus ){
        this.campus = campus;
    }
}
