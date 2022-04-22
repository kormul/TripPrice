package com.tourguide.tripprice.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerServiceImpl implements TripPricerService {
	
	private Logger logger = LogManager.getLogger();
	
	private ExecutorService executorService = Executors.newFixedThreadPool(32000);

	private TripPricer tripPricer = new TripPricer();
	
	
	public List<Provider> getPrice(String apiKey, UUID userId, int adults, int children, int duration, int rewardsPoints){
		
		logger.debug("Get Price");
		
		try {
			return CompletableFuture.supplyAsync(()-> {	
				return tripPricer.getPrice(apiKey, userId, adults, children, duration, rewardsPoints);
			}, executorService ).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
