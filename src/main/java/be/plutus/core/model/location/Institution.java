package be.plutus.core.model.location;

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
    @Column( name = "slur", unique = true )
    private String slur;

    @Column( name = "hint" )
    private String hint;

    @NotBlank( message = "{NotBlank.Institution.usernamePattern}" )
    @Column( name = "username_pattern" )
    private String usernamePattern;

    public Institution(){
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

    public String getHint(){
        return hint;
    }

    public void setHint( String hint ){
        this.hint = hint;
    }

    public String getUsernamePattern(){
        return usernamePattern;
    }

    public void setUsernamePattern( String usernamePattern ){
        this.usernamePattern = usernamePattern;
    }
}
