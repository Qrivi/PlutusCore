package be.plutus.api.response;

import be.plutus.api.response.meta.DefaultMeta;

public abstract class GenericResponse<M extends DefaultMeta, O extends Object>{

    private String error;
    private M meta;
    private O data;

    public String getError(){
        return error;
    }

    public M getMeta(){
        return meta;
    }

    public O getData(){
        return data;
    }
}
