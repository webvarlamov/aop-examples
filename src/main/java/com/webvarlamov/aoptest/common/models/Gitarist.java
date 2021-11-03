package com.webvarlamov.aoptest.common.models;

public class Gitarist implements Signer {
    private String message = "♫ You're gonna live forever in me";

    @Override
    public void sign() {
        System.out.println(message);
    }
}
