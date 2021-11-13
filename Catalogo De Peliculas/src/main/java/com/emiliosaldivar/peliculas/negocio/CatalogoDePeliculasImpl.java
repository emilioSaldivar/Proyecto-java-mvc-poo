
package com.emiliosaldivar.peliculas.negocio;

import com.emiliosaldivar.peliculas.datos.AccesoDatosImpl;
import com.emiliosaldivar.peliculas.datos.IAccesoDatos;
import com.emiliosaldivar.peliculas.domain.Pelicula;
import java.io.FileNotFoundException;
import java.util.List;


public class CatalogoDePeliculasImpl implements ICatalogoPeliculas{
    private final IAccesoDatos datos;

    public CatalogoDePeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void agregarPelicula(String nombrePleicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePleicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (FileNotFoundException ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void listarPelicula(String nombreArchivo) {
        List<Pelicula> miListaDePeliculas = this.datos.listar(nombreArchivo);
        miListaDePeliculas.forEach(pelicula -> {
            System.out.println("pelicula = " + pelicula);
        });
    }

    @Override
    public void buscarPelicula(String nombreArchio, String buscar) {
        String resultado = null;
        resultado = this.datos.buscar(nombreArchio, buscar);
        System.out.println("Resultado: " +  resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (this.datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }else{
                datos.crear(nombreArchivo);
                System.out.println("Se creo un nuevo archivo\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error al crear el archivo de peliculas");
        }
    }
}
