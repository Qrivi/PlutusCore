package be.plutus.core.currency;

public enum Currency{
    EUR( "euro", "\u20AC", 1 ),
    USD( "dollar", "\u0024", 0.9136 ),
    GBP( "pound", "\u00A3", 1.3630 );

    private final String name;
    private final String symbol;
    private final double valueInEuro;

    Currency( String name, String symbol, double valueInEuro ){
        this.name = name;
        this.symbol = symbol;
        this.valueInEuro = valueInEuro;
    }

    public static Currency getFromName( String name ){
        for( Currency currency : values() )
            if( currency.name.equals( name ) )
                return currency;
        return null;
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getValueInEuro(){
        return valueInEuro;
    }

    @Override
    public String toString(){
        return getName();
    }
}
