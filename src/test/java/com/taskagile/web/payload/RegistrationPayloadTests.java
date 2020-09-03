package com.taskagile.web.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RegistrationPayloadTests {
  private static Validator validator;

  @BeforeAll
  static void setup() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void validate_blankPayload_shouldFail() {
    RegistrationPayload payload = new RegistrationPayload();
    Set<ConstraintViolation<RegistrationPayload>> violations = validator.validate(payload);
    assertEquals(3, violations.size());
  }
}
