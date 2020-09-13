
package triangulos;

import java.util.*; 
import java.io.*;

// ACTIVIDAD 2

public class Triangulo {
    
    public static int calculoRegistros() throws IOException {
        
        int registros = 0;
        Scanner leer  = new Scanner(new File("src/triangulos/Triangulos.txt"));
        
        while(leer.hasNextLine()) {
            leer.nextLine();
            registros++;
        }
        leer.close();
        
        return(registros);
    } // fin calculoRegistros() 2.
    
    public static void leoArchivo(double coordenadas[][]) throws IOException {
        
        int registros = 0;
        Scanner leer  = new Scanner(new File("src/triangulos/Triangulos.txt"));
        
        while(leer.hasNext()) {
            for(int i=0; i<coordenadas[0].length; i++) {
                coordenadas[registros][i] = leer.nextDouble();
            }
        registros++;            
        }
        leer.close();        
    } // fin leoArchivo() 3.
    
    public static void mostrarDatos1(double coordenadas[][]) {
        
        int contador = 1; 
        
        System.out.println("    Coordenadas tres puntos del triangulo");        
        System.out.printf("%-6s %-6s %-6s %-6s %-6s %-6s %s\n", "Tri", "X1", "Y1", "X2", "Y2", "X3", "Y3");
        
        for(int i=0; i<coordenadas.length; i++) {
            System.out.printf(" %d  ",contador);
            for(int j=0; j<coordenadas[0].length; j++) {
                System.out.printf("%6.2f ",coordenadas[i][j]);
            }contador++;
            System.out.println("");
        }
    } // fin mostrarDatos1() 4.
    
    private static double[][] calculoCatetos(double coordenadas[][]) {
        
        double catetos[][] = new double[coordenadas.length][3];
        
        for(int i=0; i<coordenadas.length; i++) {
               // P1P2
               catetos[i][0] = Math.sqrt(Math.pow((coordenadas[i][2] - coordenadas[i][0]), 2) + 
                                         Math.pow((coordenadas[i][3] - coordenadas[i][1]), 2));
               // P2P3
               catetos[i][1] = Math.sqrt(Math.pow((coordenadas[i][4] - coordenadas[i][2]), 2) + 
                                         Math.pow((coordenadas[i][5] - coordenadas[i][3]), 2));
               // P3P1
               catetos[i][2] = Math.sqrt(Math.pow((coordenadas[i][0] - coordenadas[i][4]), 2) + 
                                         Math.pow((coordenadas[i][1] - coordenadas[i][5]), 2)); 
        }
        return(catetos);
    } // fin calculoCatetos() 5.
    
    private static double[] calculoHipotenusa(double catetos[][]) {
        
        double menor = 0, medio = 0, mayor = 0, medio1 = 0, medioFinal = 0;
        
        double hipoCalculada[]  = new double[catetos.length];
        double hipoReal[]       = new double[catetos.length];
            
            for(int i=0; i<hipoCalculada.length; i++) {
                
                mayor  = Math.max((Math.max(catetos[i][0], catetos[i][1])), catetos[i][2]);
                menor  = Math.min((Math.min(catetos[i][0], catetos[i][1])), catetos[i][2]);
                
                medio  = Math.max((Math.min(catetos[i][0], catetos[i][1])), catetos[i][2]);
                medio1 = Math.max((Math.min(catetos[i][2], catetos[i][1])), catetos[i][0]);
                
                medioFinal = Math.min(medio, medio1);
                
                hipoCalculada[i] = Math.sqrt(Math.pow(medioFinal, 2) + Math.pow(menor, 2));
                
                hipoReal[i] = mayor;               
            }
            return(hipoCalculada);
    } // fin calculoHipotenusa() 6.
    
    private static String[] tipoTriangulo(double hipoCalculada[], double hipoReal[],double catetos[][]) {
        
        double mayor = 0;
        
        hipoCalculada    = Triangulo.calculoHipotenusa(catetos);
        String estatus[] = new String[catetos.length];
        
        for(int i=0; i<hipoCalculada.length; i++) {
            
            mayor = Math.max((Math.max(catetos[i][0], catetos[i][1])), catetos[i][2]);
            hipoReal[i] = mayor;
            
            if(Math.round(hipoCalculada[i]) == Math.round(hipoReal[i])) {
                estatus[i] = "Triangulo Rectangulo";                
                if(catetos[i][0] != catetos[i][1] && catetos[i][2] != catetos[i][0] && catetos[i][1] != catetos[i][2]) {
                    estatus[i] = "Triangulo Rectangulo Escaleno"; 
                } 
                if(catetos[i][0] == catetos[i][1] || catetos[i][2] == catetos[i][0] || catetos[i][1] == catetos[i][2]) {                
                    estatus[i] = "Triangulo Rectangulo Isosceles";                 
                }            
            }else{ 
                estatus[i] = "No es un Triangulo Rectangulo"; 
            }   
        }
        return(estatus);
    } // fin tipoTriangulo() 7.
    
    public static void mostrarFinal(double coordenadas[][]) {
        
        double catetos[][]     =  Triangulo.calculoCatetos(coordenadas);
        double hipoCalculada[] =  Triangulo.calculoHipotenusa(catetos);
        double hipoReal[]      =  new double[coordenadas.length];
        String estatus[]       =  Triangulo.tipoTriangulo(hipoCalculada, hipoReal, catetos);        
        
        int contador = 1;
        
        System.out.println("");
        System.out.printf("%s  %s\n","Tri","Estatus");        
        for(int i=0; i<coordenadas.length; i++) {            
            System.out.printf(" %d   %s\n", contador++, estatus[i]);                      
        }
        
        System.out.println("");
        System.out.printf("Tri%10s   %10s   %10s   %10s   %10s\n", "CatetoA", "CatetoB", "CatetoC", "HipoCalcu", "HipoReal");
        contador = 1; 
        for(int i=0; i<coordenadas.length; i++) {
            System.out.printf(" %d %10.4f   %10.4f   %10.4f   %10.4f   %10.4f\n", contador++, catetos[i][0], catetos[i][1], catetos[i][2], hipoCalculada[i], hipoReal[i]);
        }
        System.out.println("");        
    } // fin mostrarFinal() 
    
} // fin clase Triangulo
