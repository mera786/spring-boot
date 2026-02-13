package com.app.NOT_SUPPORTED.service;

import com.app.NOT_SUPPORTED.entity.OrderLog;
import com.app.NOT_SUPPORTED.repository.OrderLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    @Autowired
    private OrderLogRepository logRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void saveLog() {
        logRepository.save(new OrderLog("Order created log"));
    }
}

