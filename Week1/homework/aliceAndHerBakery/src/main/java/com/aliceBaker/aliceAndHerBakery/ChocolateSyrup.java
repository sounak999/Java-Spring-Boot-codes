package com.aliceBaker.aliceAndHerBakery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "cake.syrup", havingValue = "chocolate")
public class ChocolateSyrup implements Syrup {
    @Override
    public void getSyrupType() {
        System.out.println("Chocolate syrup 🍫😛");
    }
}
