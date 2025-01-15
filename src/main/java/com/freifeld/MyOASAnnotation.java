package com.freifeld;

import jakarta.ws.rs.NameBinding;
import jakarta.ws.rs.core.Response;

import java.lang.annotation.*;

@Documented
@NameBinding
@Repeatable(value = MyOASAnnotation.List.class)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOASAnnotation {
    String value() default "";

    @Documented
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        MyOASAnnotation[] value();
    }
}
