package be.plutus.core.model.transaction;

public enum TransactionType{
    TOPUP( "top-up" ),
    PAYMENT( "payment" );

    private String type;

    TransactionType( String type ){
        this.type = type;
    }

    @Override
    public String toString(){
        return this.type;
    }
}
