package com.webvarlamov.aoptest.common.models;

public class GreatGitarist implements Signer{
    @Override
    public void sign() {
        System.out.println("GreatGitarist sign");
    }
}
