package com.kthsoft.security.restdata;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -6597205217764318144L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
