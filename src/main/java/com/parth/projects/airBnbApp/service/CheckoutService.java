package com.parth.projects.airBnbApp.service;

import com.parth.projects.airBnbApp.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}
