
package com.emiliosaldivar.peliculas.negocio;

public interface ICatalogoPeliculas {
    public void agregarPelicula(String nombrePleicula, String nombreArchivo);
    public void listarPelicula(String nombreArchivo);
    public void buscarPelicula(String nombreArchio, String buscar);
    public void iniciarArchivo(String nombreArchivo);
}
/*La interfaz continen las operaciones necesarias para la aplicacion del catalogo de peliculas*/
