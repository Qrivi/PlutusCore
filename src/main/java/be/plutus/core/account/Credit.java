package be.plutus.core.account;

import be.plutus.common.identifiable.Identifiable;
import be.plutus.core.currency.Currency;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "credit" )
public class Credit extends Identifiable{

    @Min( value = 0, message = "{Min.Credit.amount}" )
    @Column( name = "amount" )
    private double amount;

    @NotNull( message = "{NotNull.Credit.currency}" )
    @Column( name = "currency" )
    @Enumerated( EnumType.STRING )
    private Currency currency;

    public Credit(){
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount( double amount ){
        this.amount = amount;
    }

    public Currency getCurrency(){
        return currency;
    }

    public void setCurrency( Currency currency ){
        this.currency = currency;
    }
}
