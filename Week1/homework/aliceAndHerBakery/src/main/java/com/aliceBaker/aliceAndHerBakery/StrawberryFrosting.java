package com.aliceBaker.aliceAndHerBakery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "cake.frosting", havingValue = "strawberry")
public class StrawberryFrosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Strawberry Frosting 🍓🥶");
    }
}
