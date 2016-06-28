package be.plutus.core.account;

import be.plutus.core.location.Institution;

public abstract class User{
    private String firstName;
    private String lastName;

    private Institution institution;
    private String username;
    private String password;

    private Credit credit;

    public User(){
    }

    public User( String firstName, String lastName, Institution institution, String username, String password, Credit credit ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.institution = institution;
        this.username = username;
        this.password = password;
        this.credit = credit;
    }

    /* potential redundant constructor
    public User( String firstName, String lastName, Institution institution, String username, String password ){
        this( firstName, lastName, institution, username, password, new Credit() );
    } */

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

    public String getPassword(){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public Credit getCredit(){
        return credit;
    }

    public void setCredit( Credit credit ){
        this.credit = credit;
    }
}
