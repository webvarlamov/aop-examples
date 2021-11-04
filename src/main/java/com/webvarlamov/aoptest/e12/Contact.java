package com.webvarlamov.aoptest.e12;

import com.webvarlamov.aoptest.e13.model.IWrapperModel;
import lombok.Data;

@Data
public class Contact implements IWrapperModel {
    private String name;
    private String number;
    private String email;
    private Object someData;
    private Object someBody;

    @Override
    public void setData(Object object) {
        this.someData = object;
    }

    @Override
    public void setBody(Object object) {
        this.someBody = object;
    }
}
