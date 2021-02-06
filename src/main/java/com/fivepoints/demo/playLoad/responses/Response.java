package com.fivepoints.demo.playLoad.responses;

public class Response {
    private String message;
// constructeurs
    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }
    //getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
