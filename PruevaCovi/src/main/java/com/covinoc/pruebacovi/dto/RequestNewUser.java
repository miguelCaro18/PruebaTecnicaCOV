package com.covinoc.pruebacovi.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestNewUser {

    @NotNull(message = "identificacion must not be null")
    @Size(max=15, message = "identificacion size must be between 0 and 15")
    private String identificacion;

    @Size(min=5, max=15,message = "telefono size must be between 5 and 15")
    private String telefono;


    @Size(max=100, message = "nombre size must be between 0 and 100")
    private String nombre;


    @Size(max=100, message = "apellido size must be between 0 and 100")
    private String apellido;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "RequestNewUser{" +
                "identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
