package be.plutus.api.response;

import be.plutus.core.model.location.Institution;

public class UserDTO{

    private int index;
    private String firstName;
    private String lastName;
    private Institution institution;
    private String username;

    public UserDTO(){
    }

    public int getIndex(){
        return index;
    }

    public void setIndex( int index ){
        this.index = index;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName( String firstName ){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName( String lastName ){
        this.lastName = lastName;
    }

    public Institution getInstitution(){
        return institution;
    }

    public void setInstitution( Institution institution ){
        this.institution = institution;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername( String username ){
        this.username = username;
    }
}
