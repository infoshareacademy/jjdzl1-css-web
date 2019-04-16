package com.infoshare.academy.utils;

import java.util.UUID;

public class UUIDGeneratorForUser {

    public String getGeneratedNewUUIDForNewUser() {
        return generateNewUUIDForNewUser();
    }

    public String getGeneratedNewUUIDForForgotPasswordProcess() {
        return generateNewUUIDForNewUser();
    }

    private String generateNewUUIDForNewUser() {
        return UUID.randomUUID().toString();
    }
}
