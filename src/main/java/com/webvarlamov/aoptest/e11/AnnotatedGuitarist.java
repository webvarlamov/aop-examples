package com.webvarlamov.aoptest.e11;

import com.webvarlamov.aoptest.common.models.Signer;

public class AnnotatedGuitarist implements Signer {
    @Override
    @AdviseRequired
    public void sign() {
        System.out.println("AnnotatedGuitarist sign");
    }
}
