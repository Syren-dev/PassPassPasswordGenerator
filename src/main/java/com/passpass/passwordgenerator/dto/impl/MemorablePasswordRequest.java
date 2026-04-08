package com.passpass.passwordgenerator.dto.impl;

import com.passpass.passwordgenerator.dto.PasswordRequest;

public class MemorablePasswordRequest implements PasswordRequest {

    private int wordCount;
    private boolean capitalizeWords;
    private boolean isIncludeSymbols;
    private boolean isIncludeNumbers;
    private boolean isLeet;
    private String separator;

    @Override
    public String getType() {
        return "MEMORABLE";
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public boolean isCapitalizeWords() {
        return capitalizeWords;
    }

    public void setCapitalizeWords(boolean capitalizeWords) {
        this.capitalizeWords = capitalizeWords;
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

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public boolean isLeet() {return isLeet;}

    public void setLeet(boolean leet) {isLeet = leet;}
}
