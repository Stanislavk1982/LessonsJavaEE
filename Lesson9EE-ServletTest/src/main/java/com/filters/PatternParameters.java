package com.filters;

public enum PatternParameters {
    VALIDATION_EMAIL("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}"),
    VALIDATION_AGE("[1-9]{1,1}[0-9]{0,1}"),
    VALIDATION_PHONE("[+]{1,1}[3]{1,1}[8]{1,1}[0]{1,1}[1-9]{1,1}[0-9]{8,8}");

    PatternParameters(String pattern) {
        this.pattern = pattern;
    }

    private String pattern;

    @Override
    public String toString() {
        return pattern;
    }
}
