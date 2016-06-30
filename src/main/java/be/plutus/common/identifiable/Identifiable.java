package be.plutus.common.identifiable;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class Identifiable{

    @Id
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "generatorName" )
    @TableGenerator( name = "generatorName", allocationSize = 1 )
    @Column( name = "id" )
    private Integer id;

    @Override
    public boolean equals( Object obj ){
        return !( obj == null || id == null ) && obj instanceof Identifiable && ( (Identifiable)obj ).getId() != null && ( (Identifiable)obj ).getId().equals( this.id );
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 17 * hash + Objects.hashCode( this.id );
        return hash;
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }
}

