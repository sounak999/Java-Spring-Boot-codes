package com.homework.aliceAndHerBakery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "cake.syrup", havingValue = "strawberry")
public class StrawberrySyrup implements  Syrup {
    @Override
    public String getSyrupType() {
        return "Strawberry Syrup";
    }
}
