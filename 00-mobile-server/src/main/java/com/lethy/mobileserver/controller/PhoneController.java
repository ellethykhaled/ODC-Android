package com.lethy.mobileserver.controller;

import com.lethy.mobileserver.entity.PhoneType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PhoneController {

    @GetMapping("phone-type/")
    PhoneType getPhoneType() {
        PhoneType phoneType = new PhoneType();

        Random random = new Random();
        int randomNumber = random.nextInt(3);

        if (randomNumber < 1)
            phoneType.setPhoneType("s");
        else if (randomNumber < 2)
            phoneType.setPhoneType("i");
        else
            phoneType.setPhoneType("x");

        return phoneType;
    }
}
