package com.itq.palvarez.modelo;

public class Materia {

    private int id;
    private String valor;
    private String descripcion;
    private int curso;
    
    public Materia() {
    
    }
    
    public Materia(int id, String valor, String descripcion, int curso) {
        this.id = id;
        this.valor = valor;
        this.descripcion = descripcion;
        this.curso = curso;
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
    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }

    
    
}
