package be.plutus.core.model.preferences;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.core.model.account.Account;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table( name = "preferences" )
public class Preferences extends Identifiable{

    @Valid
    @NotNull( message = "{NotNull.Preferences.account}" )
    @OneToOne
    @JoinColumn( name = "account_id" )
    private Account account;

    @ElementCollection
    @MapKeyColumn( name = "name" )
    @Column( name = "value" )
    @CollectionTable( name = "preferences_map", joinColumns = @JoinColumn( name = "preferences_id" ) )
    private Map<String, String> prefs;

    public Preferences(){
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount( Account account ){
        this.account = account;
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

    public Map<String, String> toMap(){
        return prefs;
    }
}
