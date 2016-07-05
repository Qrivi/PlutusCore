package be.plutus.api.response;

import java.util.List;

public class AccountDTO{

    private String email;
    private List<UserDTO> users;

    public AccountDTO(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }

    public List<UserDTO> getUsers(){
        return users;
    }

    public void setUsers( List<UserDTO> users ){
        this.users = users;
    }
}
