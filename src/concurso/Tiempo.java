
package concurso;

// PARCIAL 2 

public class Tiempo {
    
    // Campos de Clase
    private String tiempoFormato;
    private int hora, minuto, minutosTotal;
    
    public Tiempo(String tiempoFormato) {
        this.tiempoFormato = tiempoFormato;
        obtenerTiempo();
        minutosTotal = minTotales();
    } // constructor()    
    
    public void obtenerTiempo() { // extrae del formato hh:mm, las horas y minutos
        hora   = Integer.parseInt(tiempoFormato.substring(0, 2));
        minuto = Integer.parseInt(tiempoFormato.substring(3, 5));
    } // fin obtenerTiempo()    
    
    public int minTotales() { // calcula los minutos totales
        int total = (hora * 60) + minuto;
        return(total);
    } // fin minTotales()
    
    // Getters
    public String getTiempoFormato() { return(tiempoFormato); }
    public int getHora() { return(hora); }
    public int getMinuto() { return(minuto); }
    public int getMinutosTotal() { return(minutosTotal); }
    
} // fin clase Tiempo
