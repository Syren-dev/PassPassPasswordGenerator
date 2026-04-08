package com.passpass.passwordgenerator.service.impl;

import com.passpass.passwordgenerator.dto.impl.MemorablePasswordRequest;
import com.passpass.passwordgenerator.service.PasswordGenerator;
import org.springframework.stereotype.Component;

@Component
public class MemorablePasswordGenerator implements PasswordGenerator <MemorablePasswordRequest>{

    @Override
    public String getType(){
        return "MEMORABLE";
    }

    @Override
    public String generatePassword(MemorablePasswordRequest request){




        return "Memorable-password";
    }

    @Override
    public Class<MemorablePasswordRequest> getRequestType(){
        return MemorablePasswordRequest.class;
    }
}
