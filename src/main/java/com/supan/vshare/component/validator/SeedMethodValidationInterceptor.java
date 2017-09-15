package com.supan.vshare.component.validator;

import com.supan.vshare.common.enums.ErrorMsgEnum;
import com.supan.vshare.common.exception.SeedParamException;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义方法验证拦截器
 *
 * @author supan
 * @date 2017年8月16日, PM 05:47:22
 */
@Slf4j
public class SeedMethodValidationInterceptor implements MethodInterceptor {

  private static Method forExecutablesMethod;

  private static Method validateParametersMethod;

  private static Method validateReturnValueMethod;

  static {
    try {
      forExecutablesMethod = Validator.class.getMethod("forExecutables");
      Class<?> executableValidatorClass = forExecutablesMethod.getReturnType();
      validateParametersMethod = executableValidatorClass.getMethod(
          "validateParameters", Object.class, Method.class, Object[].class, Class[].class);
      validateReturnValueMethod = executableValidatorClass.getMethod(
          "validateReturnValue", Object.class, Method.class, Object.class, Class[].class);
    } catch (Exception ex) {
      // Bean Validation 1.1 ExecutableValidator API not available
    }
  }


  private final Validator validator;


  /**
   * Create a new MethodValidationInterceptor using a default JSR-303 validator underneath.
   */
  public SeedMethodValidationInterceptor() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  /**
   * Create a new MethodValidationInterceptor using the given JSR-303 ValidatorFactory.
   *
   * @param validatorFactory the JSR-303 ValidatorFactory to use
   */
  public SeedMethodValidationInterceptor(ValidatorFactory validatorFactory) {
    this(validatorFactory.getValidator());
  }

  /**
   * Create a new MethodValidationInterceptor using the given JSR-303 Validator.
   *
   * @param validator the JSR-303 Validator to use
   */
  public SeedMethodValidationInterceptor(Validator validator) {
    this.validator = validator;
  }


  @Override
  @SuppressWarnings("unchecked")
  public Object invoke(MethodInvocation invocation) throws Throwable {
    Class<?>[] groups = determineValidationGroups(invocation);
    String className = invocation.getMethod().getDeclaringClass().getSimpleName();
    String methodName = invocation.getMethod().getName();
    String fullMethod = className.concat(".").concat(methodName).concat("()");
    // Standard Bean Validation 1.1 API
    Object execVal = ReflectionUtils.invokeMethod(forExecutablesMethod, this.validator);
    Method methodToValidate = invocation.getMethod();
    Set<ConstraintViolation<?>> result;

    try {
      result = (Set<ConstraintViolation<?>>) ReflectionUtils.invokeMethod(validateParametersMethod,
          execVal, invocation.getThis(), methodToValidate, invocation.getArguments(), groups);
    } catch (IllegalArgumentException ex) {
      // Probably a generic type mismatch between interface and impl as reported in SPR-12237 / HV-1011
      // Let's try to find the bridged method on the implementation class...
      methodToValidate = BridgeMethodResolver.findBridgedMethod(
          ClassUtils
              .getMostSpecificMethod(invocation.getMethod(), invocation.getThis().getClass()));
      //校验方法参数
      result = (Set<ConstraintViolation<?>>) ReflectionUtils.invokeMethod(validateParametersMethod,
          execVal, invocation.getThis(), methodToValidate, invocation.getArguments(), groups);
    }
    if (!result.isEmpty()) {
      String msgs = result.stream().map(violation -> violation.getMessage())
          .collect(Collectors.joining(","));
      String errorMsg = new StringBuffer(fullMethod).append(" 方法参数校验错误,错误信息为: ").append(msgs).toString();
      //校验结果有错
      throw new SeedParamException(ErrorMsgEnum.ILLEGAL_ARGUMENT.getCode(), errorMsg);
    }

    Object returnValue = invocation.proceed();
    //校验方法的返回值约束
    result = (Set<ConstraintViolation<?>>) ReflectionUtils.invokeMethod(validateReturnValueMethod,
        execVal, invocation.getThis(), methodToValidate, returnValue, groups);
    if (!result.isEmpty()) {
      String msgs = result.stream().map(violation -> violation.getMessage())
          .collect(Collectors.joining(","));
      String errorMsg = new StringBuffer(fullMethod).append(" 方法返回值校验错误,错误信息为: ").append(msgs).toString();
      //校验结果有错
      throw new SeedParamException(ErrorMsgEnum.ILLEGAL_ARGUMENT.getCode(), errorMsg);
    }

    return returnValue;

  }

  /**
   * Determine the validation groups to validate against for the given method invocation.
   * <p>Default are the validation groups as specified in the {@link Validated} annotation
   * on the containing target class of the method.
   *
   * @param invocation the current MethodInvocation
   * @return the applicable validation groups as a Class array
   */
  protected Class<?>[] determineValidationGroups(MethodInvocation invocation) {
    Validated validatedAnn = AnnotationUtils
        .findAnnotation(invocation.getMethod(), Validated.class);
    if (validatedAnn == null) {
      validatedAnn = AnnotationUtils
          .findAnnotation(invocation.getThis().getClass(), Validated.class);
    }
    return (validatedAnn != null ? validatedAnn.value() : new Class<?>[0]);
  }

}
