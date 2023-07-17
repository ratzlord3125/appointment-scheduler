package com.oops.ratzlord.appointmentscheduler.validation;

import com.oops.ratzlord.appointmentscheduler.entity.user.User;
import com.oops.ratzlord.appointmentscheduler.model.ChangePasswordForm;
import com.oops.ratzlord.appointmentscheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrentPasswordMatchesValidator implements ConstraintValidator<CurrentPasswordMatches, Object> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(final CurrentPasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        ChangePasswordForm form = (ChangePasswordForm) obj;
        boolean isValid = false;
        User user = userService.getUserById(form.getId());
        if (passwordEncoder.matches(form.getCurrentPassword(), user.getPassword())) {
            isValid = true;
        }
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("currentPassword").addConstraintViolation();
        }
        return isValid;
    }
}
