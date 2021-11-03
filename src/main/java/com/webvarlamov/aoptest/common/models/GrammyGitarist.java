package com.webvarlamov.aoptest.common.models;

public class GrammyGitarist implements Signer{
    @Override
    public void sign() {
        System.out.println("GrammyGitarist sign");
    }
}
