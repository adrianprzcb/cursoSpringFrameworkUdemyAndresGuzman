package com.adrian.springboot_crud.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ExistsByUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByUsername {

    
	String message() default "Ya existe en la base de datos";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}