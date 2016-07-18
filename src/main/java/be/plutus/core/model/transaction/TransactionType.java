package be.plutus.core.model.transaction;

public enum TransactionType{
    TOPUP( "top-up" ),
    PAYMENT( "payment" );

    private String type;

    TransactionType( String type ){
        this.type = type;
    }

    public static TransactionType getFromType( String name ){
        for( TransactionType type : values() )
            if( type.type.equalsIgnoreCase( name ) )
                return type;
        return null;
    }

    @Override
    public String toString(){
        return this.type;
    }
}
