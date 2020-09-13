
package concurso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// PARCIAL 2 

public class Apoyo {
    
    public static void leoArchivo(ArrayList<Equipo> equipoArray) throws IOException { // lee el .txt y lo carga a un ArrayList de tipo Equipo
        
        Scanner leer = new Scanner(new File("src/concurso/Concurso.txt"));
        String nombreEquipo;
        Equipo equipo = null;
        
        while(leer.hasNext()) {            
            Tiempo tiempos[] = new Tiempo[5];
            nombreEquipo     = leer.next();
            for(int i=0; i<tiempos.length; i++) {
                tiempos[i] = new Tiempo(leer.next());
            }
            equipo = new Equipo(nombreEquipo, tiempos);
            equipoArray.add(equipo);
        }        
        leer.close();
    } // fin leoArchivo()
    
    public static void mostrarArray(ArrayList<Equipo> equipoArray) { // imprime el arrayList de los equipos
        
        int menorTiempo = 0, bandera = 0, mayorSuperadas = 0;
        Equipo team2 = null, team1 = null;
        
        System.out.printf("%-9s %22s %12s %10s \n","Equipo","________Tiempo de las Pruebas________","Min Totales","Superadas");
        for(Equipo e: equipoArray) {
            e.mostrarEquipo();
        }
        
        team2 = equipoArray.get(0);
        for(int i=0; i<equipoArray.size(); i++) {
            team1 = equipoArray.get(i);            
            if(team2.getPruebasSuperadas() < team1.getPruebasSuperadas()){
                team2 = team1;
                mayorSuperadas = team1.getPruebasSuperadas();
            }else{
                mayorSuperadas = team2.getPruebasSuperadas();
            }  
        }
        
        for(int i=0; i<equipoArray.size(); i++) {
            team1 = equipoArray.get(i); 
            if(team1.getPruebasSuperadas() == mayorSuperadas) {
                if(bandera == 0){
                    bandera = 1;
                    team2   = equipoArray.get(i);
                }else{
                    if(team2.getMinTotalesPrueba() > team1.getMinTotalesPrueba()) {
                        menorTiempo = team1.getMinTotalesPrueba();
                        team2       = team1;
                    }
                }    
            }    
        }
        
        System.out.printf("\n%-20s \n%-1s %-1s %-1s %-1d %-1s\n","Resultados de la Competencia",
        "Equipo ganador:", team2.getNombreEquipo(), "con un tiempo de", team2.getMinTotalesPrueba(), "min");
    } // fin mostrarArray()
    
} // fin clase Apoyo
