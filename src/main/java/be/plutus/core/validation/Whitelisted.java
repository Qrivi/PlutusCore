package be.plutus.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {ElementType.FIELD} )
@Retention( RetentionPolicy.RUNTIME )
@Constraint( validatedBy = {WhitelistedValidator.class} )
public @interface Whitelisted{

    String message() default "{be.plutus.core.validation.Whitelisted.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
