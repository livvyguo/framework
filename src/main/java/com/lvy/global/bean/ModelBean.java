package com.lvy.global.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by livvy on 14-5-11.
 */
public abstract class ModelBean implements Serializable {

    private int id;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
