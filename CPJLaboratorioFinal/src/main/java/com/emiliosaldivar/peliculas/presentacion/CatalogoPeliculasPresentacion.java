package com.emiliosaldivar.peliculas.presentacion;

import com.emiliosaldivar.peliculas.*;
import com.emiliosaldivar.peliculas.negocio.CatalogoDePeliculasImpl;
import java.util.Scanner;
import com.emiliosaldivar.peliculas.negocio.ICatalogoPeliculas;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int opcion = -1;
        String nombreArchivo = "peliculas.txt";
        ICatalogoPeliculas catalogoPeliculas = new CatalogoDePeliculasImpl();
        while (opcion != 0) {
            System.out.println("Elige opcion: \n");
            System.out.println("1.- Iniciar catalogo películas\n"
                             + "2.- Agregar película\n"
                             + "3.- Listar Películas\n"
                             + "4.- Buscar Película\n"
                             + "0.- Salir");
            opcion = Integer.parseInt(consola.nextLine());
            switch(opcion){
                case 1:
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula:\n");
                    String nombrePeliNueva = consola.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePeliNueva, nombreArchivo);
                    break;
                case 3:
                    catalogoPeliculas.listarPelicula(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Introduzca la pelicula que desea buscar\n");
                    String buscar = consola.nextLine();
                    catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto...\n");
                default:
                    System.out.println("Opcion desconocida introduzca una de las opciones correctas\n");
                break;
                    
                          
            }
        }
    }

}
