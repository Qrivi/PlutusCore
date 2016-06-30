package be.plutus.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WhitelistedValidator implements ConstraintValidator<Whitelisted, String>{

    private String[] blacklist = {
            "password", "pass1234", "12345678", "01234567", "baseball", "trustno1", "superman", "testtest", "computer",
            "michelle", "123456789", "0123456789", "012345678", "1234567890", "corvette", "00000000"
    };

    @Override
    public void initialize( Whitelisted constraintAnnotation ){
    }

    @Override
    public boolean isValid( String value, ConstraintValidatorContext context ){
        for( String s : blacklist )
            if( s.equalsIgnoreCase( value ))
                return false;
        return true;
    }
}
