package com.example.p03_classjournal;

import java.io.Serializable;

public class Module implements Serializable {
    private String code;
    private String title;
    private String email;

    public Module(String code, String title, String email) {
        this.code = code;
        this.title = title;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }
}
