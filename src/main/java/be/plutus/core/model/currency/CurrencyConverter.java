package be.plutus.core.model.currency;

public class CurrencyConverter{

    public static double convert( double value, Currency from, Currency to ){
        double valueInEuro = value * from.getValueInEuro();
        return valueInEuro / to.getValueInEuro();
    }
}
