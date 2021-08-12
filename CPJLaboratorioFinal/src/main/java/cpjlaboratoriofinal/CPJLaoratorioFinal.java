
package cpjlaboratoriofinal;

import com.emiliosaldivar.peliculas.*;
import com.emiliosaldivar.peliculas.negocio.CatalogoDePeliculasImpl;
import java.util.Scanner;
import com.emiliosaldivar.peliculas.negocio.ICatalogoPeliculas;
public class CPJLaoratorioFinal {

    
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        int opcion;
        String nombreArchivo ="c:\\catalogoPeliculas\\peliculas.txt";
        ICatalogoPeliculas catalogoPeliculas = new CatalogoDePeliculasImpl();
        System.out.println("Elige opcion: ");
        System.out.println("1.- Iniciar catalogo películas\n" +
                           "2.- Agregar película\n" +
                           "3.- Listar Películas\n" +
                           "4.- Buscar Película\n" +
                           "0.- Salir");
        opcion = Integer.parseInt(consola.nextLine());
        while (opcion != 0){
            if(opcion == 1){
                System.out.println("Ingrese el nomre de una pelicula a agregar:\n");
                catalogoPeliculas.agregarPelicula(consola.nextLine(), nombreArchivo);
            }
        }
    }
    
}
