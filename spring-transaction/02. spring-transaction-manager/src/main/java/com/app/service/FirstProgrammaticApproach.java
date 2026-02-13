package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

@Component
public class FirstProgrammaticApproach {

    @Autowired
    PlatformTransactionManager transactionManager;


    public void updateUser(){
        TransactionStatus status = transactionManager.getTransaction(null);
        /*  above line default ke sath ati hai jisme below table rhta hai.
| Property    | Default Value           |
| ----------- | ----------------------- |
| Propagation | REQUIRED                |
| Isolation   | DEFAULT (DB ka default) |
| Timeout     | -1 (no timeout)         |
| ReadOnly    | false                   |

         */
        try{
            System.out.println("Do Operations");
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
        }
    }

}
