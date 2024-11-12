package com.aliceBaker.aliceAndHerBakery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "cake.syrup", havingValue = "strawberry")
public class StrawberrySyrup implements Syrup {
    @Override
    public void getSyrupType() {
        System.out.println("Strawberry syrup 🍓😛");
    }
}
