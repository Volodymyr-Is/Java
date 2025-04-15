package org.example;

import org.aspectj.lang.JoinPoint;

public class SecurityAspect {
    public void checkAccess(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];

        if (!"ADMIN".equals(user.getRole())) {
            throw new SecurityException("Access denied for: " + user.getRole());
        }

        System.out.println("Access proceed for: " + user.getName());
    }
}
