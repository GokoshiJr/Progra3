
package PVendedor;

import java.io.IOException;
/*
 * @author Gokoshi Jr PROGRAMACION 3  
 */
public class Principal {
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String nombre[]   = new String[5];
        int ventas[][]    = new int[5][6];
        int total[]       = new int[6];
        double promedio[] = new double[5];
        
        Vendedor.leoArchivo(nombre, ventas);
        Vendedor.calculos(ventas, promedio, total);
        Vendedor.mostrarDatos(nombre, ventas, promedio, total);
        
    } // fin main()
    
} // fin clase Principal