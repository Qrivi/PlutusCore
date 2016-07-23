package be.plutus.core.exception;

public class AccountAlreadyExistsException extends RuntimeException{

    public AccountAlreadyExistsException(){
        super();
    }

    public AccountAlreadyExistsException( String message ){
        super( message );
    }

    public AccountAlreadyExistsException( Throwable throwable ){
        super( throwable );
    }

    public AccountAlreadyExistsException( String message, Throwable exception ){
        super( message, exception );
    }
}