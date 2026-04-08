package com.passpass.passwordgenerator.service;

public interface PasswordGenerator<T> {
    String generatePassword(T request);
    String getType();
    Class<T> getRequestType();
}
