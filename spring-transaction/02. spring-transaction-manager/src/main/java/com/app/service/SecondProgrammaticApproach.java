package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class SecondProgrammaticApproach {


    @Autowired
    private TransactionTemplate transactionTemplate;


    public void update(){
        TransactionCallback<TransactionStatus>dbOperationTask= (TransactionStatus status)->{
            System.out.println("perform operation");
            return status;
        };
        transactionTemplate.execute(dbOperationTask);


    }


}
