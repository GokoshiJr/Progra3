
package triangulos;

import java.io.IOException;

// ACTIVIDAD 2

public class Principal {

    public static void main(String[] args) throws IOException {
        
        int registros = 0, campos = 6;
        registros = Triangulo.calculoRegistros();
        
        double coordenadas[][] = new double[registros][campos];
        
        Triangulo.leoArchivo(coordenadas);
        Triangulo.mostrarDatos1(coordenadas);
        Triangulo.mostrarFinal(coordenadas);
        
    } // fin main()
    
} // fin clase Principal