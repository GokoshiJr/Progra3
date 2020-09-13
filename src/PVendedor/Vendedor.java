
package PVendedor;

import java.util.*;
import java.io.*;

/*
 * @author Gokoshi Jr PROGRAMACION 3   
 */

public class Vendedor {
    
    // Lee el contenido del archivo .txt y llena los respectivos arreglos de nombres y ventas
    public static void leoArchivo(String nombres[], int ventas[][]) throws IOException {
        
        int registros = 0;
        Scanner leer = new Scanner(new File("src/PVendedor/Ventas.txt"));
        
        while(leer.hasNextLine()) {
            while(leer.hasNext()) {
                nombres[registros] = leer.next();
                for(int i=0; i<ventas[0].length; i++) {
                    ventas[registros][i] = leer.nextInt();
                } registros++;
            }
        } leer.close();
    } // fin leoArchivo()
    
    // Se realizan los calculos correspondientes para encontrar el promedio de cada vendedor y el total de las ventas de este
    public static void calculos(int ventas[][], double promedio[], int total[]) {
        
        int acum = 0;
        
        for(int i=0; i<ventas.length; i++) {
            acum = 0;
            for(int j=0; j<ventas[0].length; j++) {
                acum += ventas[i][j];
            }
            promedio[i] = (double) acum/ventas[0].length; // Calculo de promedio
        }        
        
        for(int j=0; j<ventas[0].length; j++) {
            for(int i=0; i<ventas.length; i++) {
                total[j] += ventas[i][j]; // Calculo del total
            }
        }
    } // fin calculos()
    
    // Muestra los datos contenidos en los arreglos
    public static void mostrarDatos(String nombres[], int ventas[][], double promedio[], int total[]) {
        
        System.out.printf("\t%50s\n\n","Lista de Vendedores con sus ventas");
        System.out.printf("%-10s %7s %8s %10s %9s %8s %10s %12s\n",
                          "Nombre","Enero","Feb","Marzo","Abril","Mayo","Junio","Promedio");
        
        for(int i=0; i<5; i++) {
            System.out.printf("%-8s",nombres[i]);
            for(int j=0; j<6; j++) {
                System.out.printf("%10s", ventas[i][j]);
            }
            System.out.printf("\t %8.2f\n",promedio[i]);
        }
        
        System.out.printf("\nTotal mes:");
        
        for(int e:total) {
            System.out.printf("%8d  ", e);
        }
        System.out.println("");
        
    } // fin mostrarDatos()
    
} // fin clase Vendedor