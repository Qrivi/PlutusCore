package be.plutus.core.account;

import be.plutus.core.account.preferences.Preferences;

public class Account{

    private String email;
    private String password;
    private User user;
    private Preferences preferences;

    public Account(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public User getUser(){
        return user;
    }

    public void setUser( User user ){
        this.user = user;
    }

    public Preferences getPreferences(){
        return preferences;
    }

    public void setPreferences( Preferences preferences ){
        this.preferences = preferences;
    }
}
