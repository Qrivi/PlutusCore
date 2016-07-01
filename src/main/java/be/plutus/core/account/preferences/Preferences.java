package be.plutus.core.account.preferences;

import be.plutus.common.identifiable.Identifiable;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table( name = "preferences" )
public class Preferences extends Identifiable{

    @ElementCollection
    @MapKeyColumn( name = "name" )
    @Column( name = "value" )
    @CollectionTable( name = "preferences_map", joinColumns = @JoinColumn( name = "preference_id" ) )
    private Map<String, String> prefs;

    public Preferences(){
    }

    public boolean exists( String key ){
        return prefs.containsKey( key );
    }

    public String get( String key ){
        return prefs.get( key );
    }

    public void set( String key, String value ){
        prefs.put( key, value );
    }
}
