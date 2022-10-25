package co.fullstacklabs.cuboid.challenge.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VolumeValidator.class)
@Documented
public @interface Volume {
    String message() default "must be a valid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}