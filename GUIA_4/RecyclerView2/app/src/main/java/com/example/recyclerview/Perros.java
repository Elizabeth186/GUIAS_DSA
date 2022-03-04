package com.example.recyclerview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Perros implements Serializable {
    private int id;

    @SerializedName("Nombre")
    private String Nombre;

    @SerializedName("Raza")
    private String Raza;

    public Perros(int id, String Nombre, String Raza) {
        this.setId(id);
        this.setNombre(Nombre);
        this.setRaza(Raza);

    }
   public Perros(){}
    public int getId(int id) { return id;}
    public void setId(int id) { this.id = id; }

    public String getNombre() { return Nombre;}
    public void setNombre(String Nombre) { this.Nombre = Nombre; }

    public String getRaza() { return Raza;}
    public void setRaza(String Raza) { this.Raza = Raza; }
}



