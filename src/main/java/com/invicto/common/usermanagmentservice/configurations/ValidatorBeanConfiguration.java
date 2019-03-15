package com.invicto.common.usermanagmentservice.configurations;

import com.invicto.common.usermanagmentservice.util.Validator;
import com.invicto.common.usermanagmentservice.util.impl.AdressValidator;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import com.invicto.common.usermanagmentservice.util.impl.MobileNumberValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorBeanConfiguration {

    @Bean(name = "emailValidatorBean")
    public Validator createEmailValidator(){
        return new EmailValidator();
    }
    @Bean(name = "adressValidatorBean")
    public Validator createAdressValidator(){
        return new AdressValidator();
    }
    @Bean(name = "mobileNumberValidatorBean")
    public Validator createMobileNumberValidator(){
        return new MobileNumberValidator();
    }
}
