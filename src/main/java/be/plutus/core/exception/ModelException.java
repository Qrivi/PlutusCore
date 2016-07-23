package be.plutus.core.exception;

public class ModelException extends RuntimeException{

    public ModelException(){
        super();
    }

    public ModelException( String message ){
        super( message );
    }

    public ModelException( Throwable throwable ){
        super( throwable );
    }

    public ModelException( String message, Throwable exception ){
        super( message, exception );
    }
}