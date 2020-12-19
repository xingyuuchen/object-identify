package com.cxy.oi.app.model;

import com.cxy.oi.kernel.protocol.ConstantsProtocol;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface ObjectType {

    int value() default ConstantsProtocol.ObjectItem.TYPE_PLANT;


}