package com.passpass.passwordgenerator.dto.impl;

import com.passpass.passwordgenerator.dto.PasswordRequest;

public class RandomPasswordRequest implements PasswordRequest {
    private int length;
    private boolean includeUpperCase;
    private boolean isIncludeLowerCase;
    private boolean isIncludeSymbols;
    private boolean isIncludeNumbers;

    @Override
    public String getType() {
        return "RANDOM";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isIncludeUpperCase() {
        return includeUpperCase;
    }

    public void setIncludeUpperCase(boolean includeUpperCase) {
        this.includeUpperCase = includeUpperCase;
    }

    public boolean isIncludeLowerCase() {
        return isIncludeLowerCase;
    }

    public void setIncludeLowerCase(boolean includeLowerCase) {
        isIncludeLowerCase = includeLowerCase;
    }

    public boolean isIncludeSymbols() {
        return isIncludeSymbols;
    }

    public void setIncludeSymbols(boolean includeSymbols) {
        isIncludeSymbols = includeSymbols;
    }

    public boolean isIncludeNumbers() {
        return isIncludeNumbers;
    }

    public void setIncludeNumbers(boolean includeNumbers) {
        isIncludeNumbers = includeNumbers;
    }
}
