package be.plutus.core.account;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.core.location.Institution;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "user" )
public class User extends Identifiable{

    @NotBlank( message = "{NotBlank.User.firstName}" )
    @Column( name = "first_name" )
    private String firstName;

    @NotBlank( message = "{NotBlank.User.lastName}" )
    @Column( name = "last_name" )
    private String lastName;

    @Valid
    @NotNull( message = "{NotNull.User.Institution}" )
    @OneToOne
    @JoinColumn( name = "institution_id" )
    private Institution institution;

    @NotBlank( message = "{NotBlank.User.username}" )
    @Column( name = "username" )
    private String username;

    @NotBlank( message = "{NotBlank.User.password}" )
    @Column( name = "password" )
    private String password;

    @Valid
    @NotNull( message = "{NotNull.User.credit}" )
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn( name = "credit_id" )
    private Credit credit;

    @Valid
    @ManyToOne
    @JoinColumn( name = "account_id" )
    private Account account;

    public User(){
    }

    public User( String firstName, String lastName, Institution institution, String username, String password, Credit credit ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.institution = institution;
        this.username = username;
        this.password = password;
        this.credit = credit;
    }

    /* potential redundant constructor
    public User( String firstName, String lastName, Institution institution, String username, String password ){
        this( firstName, lastName, institution, username, password, new Credit() );
    } */

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName( String firstName ){
        this.firstName = firstName.trim();
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName( String lastName ){
        this.lastName = lastName.trim();
    }

    public Institution getInstitution(){
        return institution;
    }

    public void setInstitution( Institution institution ){
        this.institution = institution;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername( String username ){
        this.username = username.trim();
    }

    public String getPassword(){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public Credit getCredit(){
        return credit;
    }

    public void setCredit( Credit credit ){
        this.credit = credit;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount( Account account ) {
        this.account = account;
    }
}
