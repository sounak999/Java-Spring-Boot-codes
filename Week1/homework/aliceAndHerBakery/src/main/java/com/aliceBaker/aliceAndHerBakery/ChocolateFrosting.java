package com.aliceBaker.aliceAndHerBakery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "cake.frosting", havingValue = "chocolate")
public class ChocolateFrosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Chocolate frosting 🍫🥶");
    }
}
