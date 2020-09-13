
package universidad;

import java.io.IOException;

// PARCIAL 4 

public class Principal {

    public static void main(String[] args) throws IOException {
                
        int registros = Support.calculoRegistros();
        Persona personas[] = new Persona[registros];
        
        Support.leoArchivo(personas);
        Support.mostrarArray(personas);
        
    } // fin main()
    
} // fin clase Principal
