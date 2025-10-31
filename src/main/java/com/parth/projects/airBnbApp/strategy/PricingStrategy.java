package com.parth.projects.airBnbApp.strategy;

import com.parth.projects.airBnbApp.entity.Inventory;

import java.math.BigDecimal;
public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
