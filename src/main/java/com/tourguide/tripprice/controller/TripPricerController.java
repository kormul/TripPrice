package com.tourguide.tripprice.controller;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.tripprice.exception.ConversionException;
import com.tourguide.tripprice.service.TripPricerService;

import tripPricer.Provider;

@RestController
public class TripPricerController {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	TripPricerService tripPricerService;
	
	@GetMapping("/getTripPricer")
	public List<Provider> getPrice(@RequestParam String apiKey, String userStringId, int adults, int children, int duration, int rewardsPoints) throws ConversionException{
		UUID userId = null;
		try {
			logger.debug("Get Request TripPricer");
			userId = UUID.fromString(userStringId);
		}catch (IllegalArgumentException e) {
			throw new ConversionException(userStringId);
		}
		return tripPricerService.getPrice(apiKey, userId, adults, children, duration, rewardsPoints);
	}
	
}
