package be.plutus.api.response.meta;

public class AccountMeta extends  DefaultMeta{
    private String email;

    public AccountMeta(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }
}
