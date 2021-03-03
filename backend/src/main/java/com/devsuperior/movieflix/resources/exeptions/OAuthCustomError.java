package com.devsuperior.movieflix.resources.exeptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OAuthCustomError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;

    @JsonProperty("error_description")
    private String ErrorDescription;

    public OAuthCustomError() {
    }

    public OAuthCustomError(String error, String errorDescription) {
        this.error = error;
        ErrorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        ErrorDescription = errorDescription;
    }
}
