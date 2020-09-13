
package concurso;

import java.io.IOException;
import java.util.ArrayList;
 
// PARCIAL 2 

public class Principal {

    public static void main(String[] args) throws IOException {        
        
        ArrayList<Equipo> equipoArray = new ArrayList<>();
        Apoyo.leoArchivo(equipoArray);
        Apoyo.mostrarArray(equipoArray);
        
    } // fin main()
    
} // fin clase Principal
