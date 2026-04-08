package com.passpass.passwordgenerator.service;
import com.passpass.passwordgenerator.dto.PasswordRequest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PasswordService {

    private final Map<String, PasswordGenerator<? extends PasswordRequest>> generators;

    public PasswordService(List<PasswordGenerator<?extends PasswordRequest>> generators) {
        this.generators = generators.stream().collect(Collectors.toMap(PasswordGenerator::getType,g->g));
    }

    public String generate(PasswordRequest request){
        PasswordGenerator<? extends PasswordRequest> generator = generators.get(request.getType());
        return generateType(generator, request);
    }

    private <T extends PasswordRequest> String generateType(PasswordGenerator<T> generator, PasswordRequest request) {
        T typedRequest=generator.getRequestType().cast(request);
        return generator.generatePassword(typedRequest);
    }
}
