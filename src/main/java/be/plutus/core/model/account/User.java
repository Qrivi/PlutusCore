package be.plutus.core.model.account;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.common.security.AES;
import be.plutus.core.model.location.Institution;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @NotNull( message = "{NotNull.User.creationDate}" )
    @Column( name = "creation_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date creationDate;

    @Column( name = "fetch_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date fetchDate;

    @Valid
    @ManyToOne
    @JoinColumn( name = "account_id" )
    private Account account;

    public User(){
    }

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

    public String getPlainTextPassword(){
        return AES.decrypt(password);
    }

    public void setPlainTextPassword( String password ){
        this.password = AES.encrypt(password);
    }

    public Credit getCredit(){
        return credit;
    }

    public void setCredit( Credit credit ){
        this.credit = credit;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public void setCreationDate( Date creationDate ){
        this.creationDate = creationDate;
    }

    public Date getFetchDate(){
        return fetchDate;
    }

    public void setFetchDate( Date fetchDate ){
        this.fetchDate = fetchDate;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount( Account account ){
        this.account = account;
    }
}
