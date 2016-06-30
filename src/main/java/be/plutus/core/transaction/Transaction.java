package be.plutus.core.transaction;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.core.account.User;
import be.plutus.core.location.Location;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "transaction" )
public class Transaction extends Identifiable{

    @NotBlank( message = "{NotBlank.Transaction.title" )
    @Column( name = "title" )
    private String title;

    @Column( name = "description" )
    private String description;

    @Min( value = 0, message = "{Min.Transaction.amount}" )
    @Column( name = "amount" )
    private double amount;

    @NotNull( message = "{NotNull.Transaction.type}" )
    @Column( name = "type" )
    @Enumerated( EnumType.STRING )
    private TransactionType type;

    @Valid
    @NotNull( message = "{NotNull.Transaction.location}" )
    @ManyToOne
    @JoinColumn( name = "location_id" )
    private Location location;

    @NotNull( message = "{NotNull.Transaction.timestamp}" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date timestamp;

    @Valid
    @NotNull( message = "{NotNull.Transaction.user}" )
    @ManyToOne
    @JoinColumn( name = "user_id" )
    private User user;

    public Transaction(){
    }

    public String getTitle(){
        return title;
    }

    public void setTitle( String title ){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description ){
        this.description = description;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount( double amount ){
        this.amount = amount;
    }

    public TransactionType getType(){
        return type;
    }

    public void setType( TransactionType type ){
        this.type = type;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation( Location location ){
        this.location = location;
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public void setTimestamp( Date timestamp ){
        this.timestamp = timestamp;
    }

    public User getUser(){
        return user;
    }

    public void setUser( User user ){
        this.user = user;
    }
}
