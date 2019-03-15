package com.invicto.common.usermanagmentservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.invicto.common.usermanagmentservice.entity.Role;
import com.invicto.common.usermanagmentservice.repository.RoleRepository;
import com.invicto.common.usermanagmentservice.repository.UserDetailRepository;
import com.invicto.common.usermanagmentservice.util.Validator;
import com.invicto.common.usermanagmentservice.util.impl.AdressValidator;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import com.invicto.common.usermanagmentservice.util.impl.MobileNumberValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableSwagger2
public class UserManagmentServiceApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(UserManagmentServiceApplication.class, args);
		Arrays.stream(con.getBeanDefinitionNames()).forEach(s->System.out.println(s));

	}

	@Bean
	Gson createGson() {

		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	}

}

