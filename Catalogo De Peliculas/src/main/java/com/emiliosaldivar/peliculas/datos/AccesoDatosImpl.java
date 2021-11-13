
package com.emiliosaldivar.peliculas.datos;

import com.emiliosaldivar.peliculas.domain.Pelicula;
import java.io.*;
import java.util.*;


public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        List <Pelicula> miLista = new ArrayList <>();
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null){
                Pelicula pelicula =new Pelicula(linea);
                miLista.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("El archivo no se ha encontrado\n");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return miLista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se ha escrito al archivo" +  pelicula);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("No se encontro el archivo\n");
        } catch (IOException ex) {
            System.out.println("No se pudo escribir al archivo\n");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        boolean bandera = false;
        int indice = 1;
        String retorno= "No se encontro la pelicula buscada";
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null){
                
                if (buscar != null && buscar.equalsIgnoreCase(linea)){
                    retorno = "Se encontro la pelicula: "+ linea +  "\nEn el indice: " + Integer.toString(indice);
                    break;
                }
                linea = entrada.readLine();
                indice++;
                
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("El archivo no se ha encontrado\n");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return retorno;
    }

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo en memoria");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }
    
}
