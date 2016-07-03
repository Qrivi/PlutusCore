package be.plutus.api.response.meta;

import java.util.Date;

public class DefaultMeta{

    private int statusCode;
    private Date timestampRequest;

    public int getStatusCode(){
        return statusCode;
    }

    public void setStatusCode( int statusCode ){
        this.statusCode = statusCode;
    }

    public Date getTimestampRequest(){
        return timestampRequest;
    }

    public void setTimestampRequest( Date timestampRequest ){
        this.timestampRequest = timestampRequest;
    }
}
