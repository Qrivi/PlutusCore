package be.plutus.api.response;

import be.plutus.api.response.meta.DefaultMeta;

public class Response<M extends DefaultMeta, O extends Object>{

    private String error;
    private M meta;
    private O data;

    public String getError(){
        return error;
    }

    public void setError( String error ){
        this.error = error;
    }

    public M getMeta(){
        return meta;
    }

    public void setMeta( M meta ){
        this.meta = meta;
    }

    public O getData(){
        return data;
    }

    public void setData( O data ){
        this.data = data;
    }
}
