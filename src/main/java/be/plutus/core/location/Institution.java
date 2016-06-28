package be.plutus.core.location;

/**
 * Created by Krivi on 28/06/16.
 */
public enum Institution{
    UCLL("ucll", "University-Colleges Leuven-Limburg");

    private String slur;
    private String name;

    Institution( String slur, String name ){
        this.slur = slur;
        this.name = name;
    }

    public String getSlur(){
        return slur;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return getName();
    }
}
