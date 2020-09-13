
package concurso;

// PARCIAL 2 

public class Equipo {
    
    // Campos de clase
    private String nombreEquipo;
    private Tiempo tiempos[];
    private int pruebasSuperadas, minutosTotalesPrueba;
    
    public Equipo(String nombreEquipo, Tiempo tiempos[]) {
        this.nombreEquipo = nombreEquipo;
        this.tiempos      = tiempos;
        actualizarEquipo();        
    } // fin Constructor
    
    // Getters
    public int getPruebasSuperadas() { return(pruebasSuperadas); }
    public int getMinTotalesPrueba() { return(minutosTotalesPrueba); }
    public String getNombreEquipo()  { return(nombreEquipo); }
    
    public void actualizarEquipo() { // actualiza los atributos de minutosTotalesPrueba y pruebasSuperadas
        for(int i=0; i<tiempos.length; i++){            
            if(tiempos[i].getHora() > 0 || tiempos[i].getMinuto() > 0){
                pruebasSuperadas++;
            }
            minutosTotalesPrueba += tiempos[i].getMinutosTotal();
        }        
    } // fin actualizarEquipo()
    
    public void mostrarEquipo(){ // muestra los atributos
        System.out.printf("%-10s",nombreEquipo);
        for(int i=0; i<tiempos.length; i++){
            System.out.printf("%-8s",tiempos[i].getTiempoFormato());
        }
        System.out.printf("%6d %10d \n",minutosTotalesPrueba, pruebasSuperadas);        
    } // fin mostrarEquipo
    
} // fin de clase Equipo
