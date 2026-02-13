package com.app.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService {


//    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);


    public void pay() {
        log.info("Payment process started");

        try {
            int amount = 1000;
            log.debug("Payment amount: {}", amount);

            if(amount > 5000) {
                log.warn("High amount transaction");
            }

            // simulate error
            int x = 10 / 0;

        } catch (Exception e) {
            log.error("Payment failed", e);
        }
    }
}

