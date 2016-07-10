package be.plutus.core.config;

import be.plutus.core.model.currency.Currency;

public class Config{

    public static final long DEFAULT_TOKEN_TTL = new Long( "5184000000" ); // 60 days

    public static final Currency DEFAULT_CURRENCY = Currency.EUR;

    public static final int DEFAULT_TRANSACTION_OFFSET = 0;
    public static final int DEFAULT_TRANSACTION_LIMIT = 50;
}
