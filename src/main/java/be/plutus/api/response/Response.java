package be.plutus.api.response;

import be.plutus.api.response.meta.DefaultMeta;

import java.util.Arrays;
import java.util.Collection;

public class Response<M extends DefaultMeta, O extends Object>{

    private Collection<String> errors;
    private M meta;
    private O data;

    public Collection<String> getErrors(){
        return errors;
    }

    public void setErrors( String... errors ){
        this.errors = Arrays.asList( errors );
    }

    public void setErrors( Collection<String> errors ){
        this.errors = errors;
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
