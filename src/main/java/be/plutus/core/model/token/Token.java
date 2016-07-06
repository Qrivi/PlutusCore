package be.plutus.core.model.token;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.core.model.account.Account;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "token" )
public class Token extends Identifiable{

    @Valid
    @NotNull( message = "{NotNull.Token.account}" )
    @ManyToOne
    @JoinColumn( name = "account_id" )
    private Account account;

    @NotBlank( message = "{NotBlank.Token.token}" )
    @Column( name = "token", unique = true )
    private String token;

    @NotBlank( message = "{NotBlank.Token.applicationName}" )
    @Column( name = "application_name" )
    private String applicationName;

    @NotBlank( message = "{NotBlank.Token.deviceName}" )
    @Column( name = "device_name" )
    private String deviceName;

    @NotBlank( message = "{NotBlank.Token.requestIp}" )
    @Column( name = "request_ip" )
    private String requestIp;

    @NotNull( message = "{NotNull.Token.expiryDate}" )
    @Column( name = "expiry_date" )
    @Temporal( value = TemporalType.TIMESTAMP )
    private Date expiryDate;

    @NotNull( message = "{NotNull.Token.creationDate}" )
    @Column( name = "creation_date" )
    @Temporal( value = TemporalType.TIMESTAMP )
    private Date creationDate;

    @Column( name = "active" )
    private boolean active;

    @OneToMany( mappedBy = "token", fetch = FetchType.EAGER )
    private Set<Request> requests;

    public Token(){
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount( Account account ){
        this.account = account;
    }

    public String getToken(){
        return token;
    }

    public void setToken( String token ){
        this.token = token;
    }

    public String getApplicationName(){
        return applicationName;
    }

    public void setApplicationName( String applicationName ){
        this.applicationName = applicationName;
    }

    public String getDeviceName(){
        return deviceName;
    }

    public void setDeviceName( String deviceName ){
        this.deviceName = deviceName;
    }

    public String getRequestIp(){
        return requestIp;
    }

    public void setRequestIp( String requestIp ){
        this.requestIp = requestIp;
    }

    public Date getExpiryDate(){
        return expiryDate;
    }

    public void setExpiryDate( Date expiryDate ){
        this.expiryDate = expiryDate;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public void setCreationDate( Date creationDate ){
        this.creationDate = creationDate;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive( boolean active ){
        this.active = active;
    }
}
