package com.light.framework.aspectj.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义导出Excel数据注解
 * 主要用于实体类的字段注解
 * @author asus
 *
 */
@Retention(RetentionPolicy.RUNTIME)//注解的生命周期
/*
 * ElementType.TYPE：说明该注解只能被声明在一个类前。

ElementType.FIELD：说明该注解只能被声明在一个类的字段前。

ElementType.METHOD：说明该注解只能被声明在一个类的方法前。

ElementType.PARAMETER：说明该注解只能被声明在一个方法参数前。

ElementType.CONSTRUCTOR：说明该注解只能声明在一个类的构造方法前。

ElementType.LOCAL_VARIABLE：说明该注解只能声明在一个局部变量前。

ElementType.ANNOTATION_TYPE：说明该注解只能声明在一个注解类型前。

ElementType.PACKAGE：说明该注解只能声明在一个包名前。
 */
@Target(ElementType.FIELD)
public @interface Excel 
{

    /**
     * 导出到Excel中的名字.
     */
    public abstract String name();

    /**
     * 提示信息
     */
    public abstract String prompt() default "";

    /**
     * 设置只能选择不能输入的列内容.
     */
    public abstract String[] combo() default {};

    /**
     * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
     */
    public abstract boolean isExport() default true;

}
