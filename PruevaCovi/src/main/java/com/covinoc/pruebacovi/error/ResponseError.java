package com.covinoc.pruebacovi.error;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ResponseError {
    private Date timestamp;
    private String mensaje;
    private HttpStatus status;
    private String path;


    public ResponseError(String mensaje, HttpStatus status) {
        super();
        this.timestamp = new Date();
        this.mensaje = mensaje;
        this.status = status;
    }
    public ResponseError(String mensaje, HttpStatus status,String path) {
        super();
        this.timestamp = new Date();
        this.mensaje = mensaje;
        this.status = status;
        this.path=path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getStatus() {
        return String.valueOf(status.value());
    }
    public String getPath(){
        return path;
    }
}
