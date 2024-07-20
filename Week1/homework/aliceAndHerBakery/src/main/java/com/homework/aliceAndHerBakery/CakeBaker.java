package com.homework.aliceAndHerBakery;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    @Autowired
    Frosting frosting;

    @Autowired
    Syrup syrup;

    @PostConstruct
    public void bakingStart() {
        System.out.println("Baking the cake...");
    }

    @PreDestroy
    public void bakingFinished() {
        System.out.println("Cake is ready to serve!");
    }

    public void bakeCake() {
        System.out.println("The frosting is done using " + frosting.getFrostingType());
        System.out.println("The syrup used is " + syrup.getSyrupType());
    }
}
