package com.supan.vshare.component.validator;

import org.aopalliance.aop.Advice;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

/**
 * Created by supan on 2017/8/16.
 */
public class SeedMethodValidationPostProcessor extends MethodValidationPostProcessor {

  @Override
  protected Advice createMethodValidationAdvice(Validator validator) {
    return (validator != null ? new SeedMethodValidationInterceptor(validator)
        : new SeedMethodValidationInterceptor());
  }
}
