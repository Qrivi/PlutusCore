package be.plutus.api.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class AuthenticationDTO{

    @NotBlank( message = "{NotBlank.AuthenticationDTO.email}" )
    @Email( message = "{Email.AuthenticationDTO.email}" )
    private String email;

    @NotBlank( message = "{NotBlank.AuthenticationDTO.password}" )
    private String password;

    public AuthenticationDTO(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail( String email ){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }
}
