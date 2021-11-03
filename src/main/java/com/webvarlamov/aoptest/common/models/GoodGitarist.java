package com.webvarlamov.aoptest.common.models;

public class GoodGitarist implements Signer{
    @Override
    public void sign() {
        System.out.println("GoodGitarist sign");
    }
}
