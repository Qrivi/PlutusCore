package be.plutus.core.model.account;

public enum AccountStatus{
    ACTIVE( "account is active" ),
    DEACTIVATED( "account has been deactivated because of general prohibited activity" ),
    DEACTIVATED_TOO_MANY_REQUESTS( "account has been deactivated because of excessive requests to the API" ),
    DEACTIVATED_FRAUDULENT_BEHAVIOR( "account has been deactivated because of fraudulent behavior" );

    private String status;

    AccountStatus( String status ){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
