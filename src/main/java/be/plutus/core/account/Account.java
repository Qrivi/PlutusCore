package be.plutus.core.account;

import be.plutus.core.account.preferences.Preferences;
import be.plutus.core.validation.Whitelisted;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "account" )
public class Account{

    @NotBlank( message = "{NotBlank.Account.email}" )
    @Email( message = "{Email.Account.email}" )
    @Column( name = "email" )
    private String email;

    @NotBlank( message = "{NotBlank.Account.password}" )
    @Size( min = 8, message = "{Min.Account.password}" )
    @Whitelisted( message = "{Whitelisted.Account.password}" )
    @Column( name = "password" )
    private String password;

    @Valid
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    private User user;

    @Valid
    @NotNull( message = "{NotNull.Account.preferences}" )
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    private Preferences preferences;

    public Account(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email.toLowerCase().trim();
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
