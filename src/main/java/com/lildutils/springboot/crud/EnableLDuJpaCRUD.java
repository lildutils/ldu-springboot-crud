package com.lildutils.springboot.crud;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.lildutils.springboot.crud.jpa.config.LDuJpaCrudConfigurer;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LDuJpaCrudConfigurer.class)
public @interface EnableLDuJpaCRUD
{

}
