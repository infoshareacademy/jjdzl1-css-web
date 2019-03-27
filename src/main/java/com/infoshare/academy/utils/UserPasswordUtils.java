package com.infoshare.academy.utils;

import com.infoshare.academy.passwordhashing.Hasher;
import com.infoshare.academy.passwordhashing.PBKDF2Hasher;

public class UserPasswordUtils {


    public static String hash(String password, PasswordHashAlgorithm hashType) {

        Hasher hasher = getHasher(hashType);

        return hasher.hash(password);
    }

    public static boolean check(String password, String attempt, PasswordHashAlgorithm hashType) {

        Hasher hasher = getHasher(hashType);

        return hasher.checkPassword(password, attempt);

    }

    private static Hasher getHasher(PasswordHashAlgorithm hashType) {

        switch (hashType) {
            case PBKDF2:
                return new PBKDF2Hasher();
            default:
                throw new UnsupportedOperationException("Unsupported hash :" + hashType);

        }
    }
}
