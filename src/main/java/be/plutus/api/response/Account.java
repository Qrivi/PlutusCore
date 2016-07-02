package be.plutus.api.response;

import java.util.List;

public class Account{

    private String email;
    private List<User> users;

    public Account( ){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers( List<User> users ){
        this.users = users;
    }
}
