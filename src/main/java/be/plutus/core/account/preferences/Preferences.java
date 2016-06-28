package be.plutus.core.account.preferences;

import java.util.Map;

public class Preferences{

    private Map<String, String> prefs;

    public Preferences(){
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
