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

    public static DefaultMeta success(){
        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 200 );
        meta.setTimestampRequest( new Date() );
        return meta;
    }

    public static DefaultMeta badRequest(){
        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 400 );
        meta.setTimestampRequest( new Date() );
        return meta;
    }

    public static DefaultMeta unauthorized(){
        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 401 );
        meta.setTimestampRequest( new Date() );
        return meta;
    }

    public static DefaultMeta forbidden(){
        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 403 );
        meta.setTimestampRequest( new Date() );
        return meta;
    }

    public static DefaultMeta serverError(){
        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 500 );
        meta.setTimestampRequest( new Date() );
        return meta;
    }

    public static DefaultMeta notFound(){
        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 404 );
        meta.setTimestampRequest( new Date() );
        return meta;
    }
}
