package com.saucedemo.annotations;

import com.saucedemo.enums.TestCategories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and
 * category details to the extent report.<p>
 *
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 *
 * @author Balaji
 * @see com.saucedemo.tests;
 * @see com.saucedemo.enums.TestCategories
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {

    /**
     * Stores the category in form of Enum Array. Include the possible values in {@link com.saucedemo.enums.TestCategories}
     */

    public TestCategories[] testCategories();
}
