package be.plutus.api.response.meta;

import be.plutus.core.model.currency.Currency;

import java.util.Date;

public class TransactionMeta extends UserMeta{

    private int offset;
    private int limit;
    private Currency currency;
    private Date timestampFetched;

    public TransactionMeta(){
    }

    public int getOffset(){
        return offset;
    }

    public void setOffset( int offset ){
        this.offset = offset;
    }

    public int getLimit(){
        return limit;
    }

    public void setLimit( int limit ){
        this.limit = limit;
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
