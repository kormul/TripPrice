package com.tourguide.tripprice.service;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerService {
	
	private Logger logger = LogManager.getLogger();
	
	private TripPricer tripPricer = new TripPricer();
	
	
	public List<Provider> getPrice(String apiKey, UUID userId, int adults, int children, int duration, int rewardsPoints){
		
		logger.debug("Get Price");
		return tripPricer.getPrice(apiKey, userId, adults, children, duration, rewardsPoints);
	}
}
