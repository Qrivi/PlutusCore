package be.plutus.core.model.account;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.common.validation.WhitelistedPassword;
import be.plutus.core.model.currency.Currency;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "account" )
public class Account extends Identifiable{

    @NotBlank( message = "{NotBlank.Account.email}" )
    @Email( message = "{Email.Account.email}" )
    @Column( name = "email", unique = true )
    private String email;

    @NotBlank( message = "{NotBlank.Account.password}" )
    @Size( min = 8, message = "{Size.Account.password}" )
    @WhitelistedPassword( message = "{WhitelistedPassword.Account.password}" )
    @Column( name = "password" )
    private String password;

    @NotNull( message = "{NotNull.Account.status}" )
    @Column( name = "status" )
    @Enumerated( EnumType.STRING )
    private AccountStatus status;

    @NotNull( message = "{NotNull.Account.creationDate}" )
    @Column( name = "creation_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date creationDate;

    @OrderBy( "creationDate" )
    @OneToMany( mappedBy = "account", fetch = FetchType.EAGER )
    private List<User> users;

    @NotNull( message = "{NotNull.Account.defaultCurrency}" )
    @Column( name = "default_currency" )
    @Enumerated( EnumType.STRING )
    private Currency defaultCurrency;

    public Account(){
    }

    public void clearPassword(){
        this.password = null;
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

    public Date getCreationDate(){
        return creationDate;
    }

    public void setCreationDate( Date creationDate ){
        this.creationDate = creationDate;
    }

    public List<User> getUsers(){
        return users;
    }

    public Currency getDefaultCurrency(){
        return defaultCurrency;
    }

    public void setDefaultCurrency( Currency defaultCurrency ){
        this.defaultCurrency = defaultCurrency;
    }
}
