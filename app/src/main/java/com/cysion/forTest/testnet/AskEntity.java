package com.cysion.forTest.testnet;

import java.io.Serializable;

public class AskEntity implements Serializable {
    private int code;
    private String query;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
