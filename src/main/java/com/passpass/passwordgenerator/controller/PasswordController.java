package com.passpass.passwordgenerator.controller;


import com.passpass.passwordgenerator.dto.impl.MemorablePasswordRequest;
import com.passpass.passwordgenerator.dto.impl.RandomPasswordRequest;
import com.passpass.passwordgenerator.service.PasswordService;
import com.passpass.passwordgenerator.service.impl.MemorablePasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/random")
    public String generateRandom(@RequestBody RandomPasswordRequest request){
        return passwordService.generate(request);
    }

    @PostMapping("/memorable")
    public String generateMemorable(@RequestBody MemorablePasswordRequest request){
        return passwordService.generate(request);
    }

}
