package com.pqm.socialnetwork.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@JsonPropertyOrder({
        "success",
        "message"
})
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = 8989479749876361196L;
    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    private HttpStatus status;

    public ApiResponse() {

    }

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.status = httpStatus;
    }

}
