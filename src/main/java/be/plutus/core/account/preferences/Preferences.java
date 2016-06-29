package be.plutus.core.account.preferences;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table( name = "preferences" )
public class Preferences{

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true )
    private Map<String, String> prefs;

    public Preferences(){
    }

    public boolean exists( String key ){
        return prefs.containsKey( key );
    }

    public String get( String key ){
        if( prefs.containsKey( key ) )
            return prefs.get( key );
        return null;
    }

    public void set( String key, String value ){
        prefs.put( key, value );
    }
}
