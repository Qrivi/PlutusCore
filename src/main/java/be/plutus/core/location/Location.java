package be.plutus.core.location;

public class Location{

    private String name;
    private Campus campus;

    public Location(){
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public Campus getCampus(){
        return campus;
    }

    public void setCampus( Campus campus ){
        this.campus = campus;
    }
}
