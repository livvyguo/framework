package com.lvy.appexec.annotation;

import java.lang.annotation.*;

/**
 * Created by livvy on 14-8-20.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface NotThreadSafe {
}
