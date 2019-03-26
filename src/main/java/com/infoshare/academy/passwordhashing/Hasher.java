package com.infoshare.academy.passwordhashing;

public interface Hasher {

    String hash(String password);

    boolean checkPassword(String password, String token);
}
