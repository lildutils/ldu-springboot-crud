package com.lildutils.springboot.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lildutils.springboot.crud.controller.advice.LDuCrudControllerAdvice;

@Configuration
@ComponentScan(basePackageClasses = LDuCrudControllerAdvice.class)
public class LDuCrudConfigurer
{

}
