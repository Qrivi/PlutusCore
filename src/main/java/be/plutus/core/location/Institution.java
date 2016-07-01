package be.plutus.core.location;

import be.plutus.common.identifiable.Identifiable;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table( name = "institution" )
public class Institution extends Identifiable{

    @NotBlank( message = "{NotBlank.Institution.name}" )
    @Column( name = "name", unique = true )
    private String name;

    @NotBlank( message = "{NotBlank.Institution.slur}" )
    @Size( max = 10, message = "{Size.Institution.slur}" )
    @Column( name = "name", unique = true )
    private String slur;

    public Institution(){
    }

    public Institution( String slur, String name ){
        this.slur = slur;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getSlur(){
        return slur;
    }

    public void setSlur( String slur ){
        this.slur = slur;
    }
}
