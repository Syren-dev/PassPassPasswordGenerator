package com.passpass.passwordgenerator.service.impl;


import com.passpass.passwordgenerator.dto.impl.RandomPasswordRequest;
import com.passpass.passwordgenerator.service.PasswordGenerator;
import com.passpass.passwordgenerator.utils.constants.PasswordConstants;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomPasswordGenerator implements PasswordGenerator<RandomPasswordRequest> {

    private static final SecureRandom RANDOM = new SecureRandom();


    @Override
    public String getType(){
        return "RANDOM";
    }

    @Override
    public Class<RandomPasswordRequest> getRequestType(){
        return RandomPasswordRequest.class;
    }

    @Override
    public String generatePassword(RandomPasswordRequest request){

        validateRequest(request);

        int selectedTypes = 0;
        int length = request.getLength();

        StringBuilder pool =  new StringBuilder();
        StringBuilder password = new StringBuilder(length);

        handleType(request.isIncludeLowerCase(), PasswordConstants.LOWERCASE,pool,password);
        handleType(request.isIncludeUpperCase(), PasswordConstants.UPPERCASE,pool,password);
        handleType(request.isIncludeNumbers(), PasswordConstants.NUMBERS,pool,password);
        handleType(request.isIncludeSymbols(), PasswordConstants.SYMBOLS,pool,password);

        if (pool.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected");
        }

        while(password.length() < length){
            password.append(getRandomChar(pool.toString()));
        }

        return shuffle(password.toString());
    }


    private void handleType(boolean selected, String value, StringBuilder pool, StringBuilder password){
        if(selected){
            pool.append(value);
            password.append(getRandomChar(value));
        }
    }

    // At leat includes one character from selected options
    private char getRandomChar(String pool){
        int index = RANDOM.nextInt(pool.length());
        return pool.charAt(index);
    }

    private String shuffle(String input){
        char[] chars = input.toCharArray();

        for(int i = chars.length -1 ; i >0; i--){
            int j = RANDOM.nextInt(i+1);

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);

    }

    private void validateRequest(RandomPasswordRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        if (request.getLength() <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }
    }

}
