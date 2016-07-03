package be.plutus.api.response;

import be.plutus.core.model.location.Location;
import be.plutus.core.model.transaction.TransactionType;

import java.util.Date;

public class TransactionDTO{

    private int id;
    private String title;
    private String description;
    private double amount;
    private TransactionType type;
    private Location location;
    private Date timestamp;

    public TransactionDTO(){
    }

    public int getId(){
        return id;
    }

    public void setId( int id ){
        this.id = id;
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
}
