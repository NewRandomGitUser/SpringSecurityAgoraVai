package com.example.securityexample.core.validator;

import javax.validation.ContraintViolation;
import com.sun.is
import com.sun.istack.NotNull;

public class Validations {
    @NotNull(message = "message deve ser preenchida")
    @Pattern(regexp = "\\d{8}", message = "nessage adota padrão de cep")
    private final String message;

    private final Integer paramExample;

    public Set<ContraintViolation<Validations>> execute() {
        final var factory = Validation.buildDefaultValidatorFactory();
        final var validaro = factory.getValidator();
        return validator.validate();
    }
}
