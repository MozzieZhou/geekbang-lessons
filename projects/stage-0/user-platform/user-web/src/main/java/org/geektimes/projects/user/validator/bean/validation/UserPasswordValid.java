package org.geektimes.projects.user.validator.bean.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserPasswordValidAnnotationValidator.class)
public @interface UserPasswordValid {

    String message() default "用户密码校验失败，请输入6-32位密码～";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String password() default "^.{6,32}$";
}
