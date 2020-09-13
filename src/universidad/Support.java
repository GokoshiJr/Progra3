
package universidad;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// PARCIAL 4

public class Support {
    
    public static int calculoRegistros() throws IOException {
        
        Scanner leer  = new Scanner(new File("src/universidad/Datos.txt"));
        int registros = 0;        
        
        while(leer.hasNextLine()) {
            leer.nextLine();
            registros++;
        }
        leer.close();
        return(registros);
    } // fin calculoRegistros()
    
    public static void leoArchivo(Persona personaArray[]) throws IOException { 
        
        Scanner leer    = new Scanner(new File("src/universidad/Datos.txt"));
        int tipoPersona = 0, registro = 0, cedula = 0;
        String nombre   = "";
        
        while(leer.hasNext()) {
            
            tipoPersona = leer.nextInt();
            nombre      = leer.next();
            cedula      = leer.nextInt();
            
            if(tipoPersona == 0) {
                personaArray[registro] = new Profesor(nombre, cedula, leer.next(), leer.nextDouble(), leer.nextInt());
            }else{
                double notas[] = new double[4];
                for(int i=0; i<4; i++){
                    notas[i] = leer.nextDouble();
                }
                personaArray[registro] = new Estudiante(nombre, cedula, notas);
            }
            registro++;
        }
        leer.close();
    } // fin leoArchivo()
    
    public static void mostrarArray(Persona personaArray[]) {
        
        int profesores = 0, estudiantes = 0;
        
        for (Persona personaArray1 : personaArray) {
            if (personaArray1 instanceof Profesor) {
                System.out.printf("\n\t\t%8s\n %22s %8s %13s %10s\n"," --- Docente ---","Nombre","Cedula","Asignatura","Pago");
                personaArray1.mostrarDatos();                
                profesores++;
                titulo();
            } else {
                personaArray1.mostrarDatos();
                estudiantes++;
            }   
        }
        System.out.println("\n\t\t El total de Profesores es: " + profesores);
        System.out.println("\t\t El total de Estudiantes es: " + estudiantes + "\n");
    } // fin mostrarArray()
    
    public static void titulo() {
        System.out.printf("\t\t --- Listado de Alumnos ---\n\t\t%7s %8s %33s %13s\n","Nombre","Cedula","____________Notas____________","Promedio");
    } // fin titulo()
    
} // fin clase Support
