package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, User> {

    private String phonePattern;

    public void initialize(UserValid annotation) {
        this.phonePattern = annotation.phonePattern();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {

        // 正则表达式匹配手机号码
        String phone = value.getPhoneNumber();
        Matcher matcher = Pattern.compile(phonePattern).matcher(phone);

        return matcher.find();
    }
}
