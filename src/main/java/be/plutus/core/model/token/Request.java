package be.plutus.core.model.token;

import be.plutus.common.identifiable.Identifiable;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "request" )
public class Request extends Identifiable{

    @NotBlank( message = "{NotBlank.Request.endpoint}" )
    @Column( name = "endpoint" )
    private String endpoint;

    @NotBlank( message = "{NotBlank.Request.ip}" )
    @Column( name = "ip" )
    private String ip;

    @Temporal( value = TemporalType.TIMESTAMP )
    @NotNull( message = "{NotNull.Request.timestamp}" )
    @Column( name = "timestamp" )
    private Date timestamp;

    @ManyToOne
    @JoinColumn( name = "token_id" )
    private Token token;

    public Request(){
    }

    public String getEndpoint(){
        return endpoint;
    }

    public void setEndpoint( String endpoint ){
        this.endpoint = endpoint;
    }

    public String getIp(){
        return ip;
    }

    public void setIp( String ip ){
        this.ip = ip;
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public void setTimestamp( Date timestamp ){
        this.timestamp = timestamp;
    }

    public Token getToken(){
        return token;
    }

    public void setToken( Token token ){
        this.token = token;
    }
}
