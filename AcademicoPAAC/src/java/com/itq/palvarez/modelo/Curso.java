package com.itq.palvarez.modelo;

public class Curso {
    private int id;
    private String valor;
    private String descripcion;
    
    public Curso() {
        
    }

    public Curso(int id, String valor, String descripcion) {
        this.id = id;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
