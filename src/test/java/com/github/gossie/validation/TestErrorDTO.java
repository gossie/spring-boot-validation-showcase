package com.github.gossie.validation;

import java.util.Map;
import java.util.Objects;

public class TestErrorDTO {

    private Map<String, String> fieldErrors;

    public TestErrorDTO(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public TestErrorDTO() {
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestErrorDTO that = (TestErrorDTO) o;
        return Objects.equals(fieldErrors, that.fieldErrors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldErrors);
    }
}
