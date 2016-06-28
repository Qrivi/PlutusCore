package be.plutus.core.account;

import be.plutus.core.currency.Currency;

public class Credit{
    private double amount;
    private Currency currency;

    public Credit(){}

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
