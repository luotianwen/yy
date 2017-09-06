package com.shifeng.mall.util;

import java.lang.annotation.*;

/**
 * TOKEN生成与删除
 * Created by caobug on 14-8-15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormToken {

    /**
     * 是否在页面生成TOKEN
     *
     * @return
     */
    boolean produce() default false;

    /**
     * 是否删除旧 TOKEN
     *
     * @return
     */
    boolean remove() default false;
}
