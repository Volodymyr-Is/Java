package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
public class TransactionAspect {
    public Object manageTransaction(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Transaction started...");
        try {
            Object result = pjp.proceed();
            System.out.println("Transaction success. Commiting changes...");
            return result;
        } catch (Exception e) {
            System.out.println("Transaction failed. Rollback...");
            throw e;
        }
    }
}
