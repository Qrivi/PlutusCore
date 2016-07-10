package be.plutus.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {ElementType.FIELD} )
@Retention( RetentionPolicy.RUNTIME )
@Constraint( validatedBy = {WhitelistedPasswordValidator.class} )
public @interface WhitelistedPassword{

    String message() default "{be.plutus.common.validation.WhitelistedPassword.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
