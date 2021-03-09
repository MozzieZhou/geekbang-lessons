package org.geektimes.projects.user.validator.bean.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidAnnotationValidator.class)
public @interface UserValid {

    String message() default "用户手机号校验失败，请输入正确的手机号信息～";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    int idRange() default 0;

    String phonePattern() default "^1[0-9]{10}$";
}
