package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPasswordValidAnnotationValidator implements ConstraintValidator<UserPasswordValid, User> {

    private String passwordPattern;

    public void initialize(UserPasswordValid annotation) {
        this.passwordPattern = annotation.password();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {

        // 正则表达式匹配手机号码
        String password = value.getPassword();
        Matcher matcher = Pattern.compile(passwordPattern).matcher(password);

        return matcher.find();
    }
}
