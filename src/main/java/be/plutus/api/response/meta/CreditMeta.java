package be.plutus.api.response.meta;

import be.plutus.core.model.currency.Currency;

import java.util.Date;

public class CreditMeta{

    private Currency currency;
    private Date timestampFetched;

    public CreditMeta( ){
    }

    public Currency getCurrency(){
        return currency;
    }

    public void setCurrency( Currency currency ){
        this.currency = currency;
    }

    public Date getTimestampFetched(){
        return timestampFetched;
    }

    public void setTimestampFetched( Date timestampFetched ){
        this.timestampFetched = timestampFetched;
    }
}
