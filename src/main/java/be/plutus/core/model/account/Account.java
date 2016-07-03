package be.plutus.core.model.account;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.common.validation.Whitelisted;
import be.plutus.core.model.account.preferences.Preferences;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table( name = "account" )
public class Account extends Identifiable{

    @NotBlank( message = "{NotBlank.Account.email}" )
    @Email( message = "{Email.Account.email}" )
    @Column( name = "email", unique = true )
    private String email;

    @NotBlank( message = "{NotBlank.Account.password}" )
    @Size( min = 8, message = "{Min.Account.password}" )
    @Whitelisted( message = "{Whitelisted.Account.password}" )
    @Column( name = "password" )
    private String password;

    @NotNull( message = "{NotNull.Account.status}" )
    @Column( name = "status" )
    @Enumerated( EnumType.STRING )
    private AccountStatus status;

    @OneToMany( mappedBy = "account", fetch = FetchType.EAGER )
    private List<User> users;

    @Valid
    @NotNull( message = "{NotNull.Account.preferences}" )
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn( name = "preferences_id" )
    private Preferences preferences;

    public Account(){
    }

    public boolean isPasswordValid( String plainTextPassword ){
        return BCrypt.checkpw( plainTextPassword, password );
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

    public void setPlainTextPassword( String plainTextPassword ){
        String salt = BCrypt.gensalt( 12 );
        this.password = BCrypt.hashpw( plainTextPassword, salt );
    }

    public AccountStatus getStatus(){
        return status;
    }

    public void setStatus( AccountStatus status ){
        this.status = status;
    }

    public List<User> getUsers(){
        return users;
    }

    public Preferences getPreferences(){
        return preferences;
    }

    public void setPreferences( Preferences preferences ){
        this.preferences = preferences;
    }
}
