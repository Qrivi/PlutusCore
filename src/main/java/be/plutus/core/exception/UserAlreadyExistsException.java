package be.plutus.core.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(){
        super();
    }

    public UserAlreadyExistsException( String message ){
        super( message );
    }

    public UserAlreadyExistsException( Throwable throwable ){
        super( throwable );
    }

    public UserAlreadyExistsException( String message, Throwable exception ){
        super( message, exception );
    }
}