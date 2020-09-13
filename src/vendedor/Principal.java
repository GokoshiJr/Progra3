
package vendedor;

import java.io.IOException;

//  PARCIAL 1  
 
public class Principal {
    
    public static void main(String[] args) throws IOException {
                
        String nombre[]   = new String[5];
        int ventas[][]    = new int[5][6];
        int total[]       = new int[6];
        double promedio[] = new double[5];
        
        Vendedor.leoArchivo(nombre, ventas);
        Vendedor.calculos(ventas, promedio, total);
        Vendedor.mostrarDatos(nombre, ventas, promedio, total);
        
    } // fin main()
    
} // fin clase Principal
