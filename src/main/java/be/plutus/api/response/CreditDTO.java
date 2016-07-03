package be.plutus.api.response;

public class CreditDTO{

    private double amount;

    public CreditDTO(  ){
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount( double amount ){
        this.amount = amount;
    }
}
