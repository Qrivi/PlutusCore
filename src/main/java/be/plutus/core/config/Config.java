package be.plutus.core.config;

import be.plutus.core.model.currency.Currency;

import java.time.ZoneId;

public class Config{

    public static final String SECRET_KEY = "ey4d2kb5lqqpqk2nrqhh";

    public static final ZoneId DEFAULT_TIMEZONE = ZoneId.of( "GMT" );
    public static final Currency DEFAULT_CURRENCY = Currency.EUR;
    public static final long DEFAULT_TOKEN_TTL = new Long( "5184000000" ); // 60 days
}
