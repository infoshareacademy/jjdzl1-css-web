package com.infoshare.academy.utils;

import java.util.UUID;

public class UUIDGeneratorForNewUser {

    public String getGeneratedNewUUIDForNewUser() {
        return generateNewUUIDForNewUser();
    }

    private String generateNewUUIDForNewUser() {
        return UUID.randomUUID().toString();
    }
}
