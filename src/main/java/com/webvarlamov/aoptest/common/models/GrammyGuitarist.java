package com.webvarlamov.aoptest.common.models;

public class GrammyGuitarist implements Signer{
    @Override
    public void sign() {
        System.out.println("GrammyGitarist sign");
    }
}
