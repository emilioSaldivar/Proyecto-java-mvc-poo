
package com.emiliosaldivar.peliculas.domain;


public class Pelicula {
    //atributos
    private String nombre;
    //constructores
    public Pelicula(){
    }
    public Pelicula(String nombrePelicula){
        this.nombre = nombrePelicula;
    }
    //metodos

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
}
