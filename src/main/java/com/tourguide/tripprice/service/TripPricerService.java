package com.tourguide.tripprice.service;

import java.util.List;
import java.util.UUID;

import tripPricer.Provider;

public interface TripPricerService {
	
	public List<Provider> getPrice(String apiKey, UUID userId, int adults, int children, int duration, int rewardsPoints);

}
