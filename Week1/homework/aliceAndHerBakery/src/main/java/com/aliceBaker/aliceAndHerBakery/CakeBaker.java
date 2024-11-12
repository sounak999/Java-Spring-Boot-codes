package com.aliceBaker.aliceAndHerBakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    @Autowired
    Frosting frosting;

    @Autowired
    Syrup syrup;

    public void bakeCake() {
        System.out.println("Baking started...");
        System.out.println("Frost:::");
        frosting.getFrostingType();
        System.out.println("Syrup:::");
        syrup.getSyrupType();
    }
}
