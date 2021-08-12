
package com.emiliosaldivar.peliculas.datos;

import com.emiliosaldivar.peliculas.domain.Pelicula;
import java.io.FileNotFoundException;
import java.util.*;


public interface IAccesoDatos{
    public boolean existe(String nombreArchivo) throws FileNotFoundException;
    public List <Pelicula> listar(String nombre) ;
    public void escribir(Pelicula pelicala, String nombreArchivo, boolean anexar);
    public String buscar(String nombreArchivo, String buscar);
    public void crear(String nombreArchivo);
    public void borrar(String nombreArchivo);
}
/*La interface contiene las operaciones a ser ejecutadas en el archivo peliculas.txt*/