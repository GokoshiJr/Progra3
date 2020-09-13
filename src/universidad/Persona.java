
package universidad;

// PARCIAL 4

public abstract class Persona implements Mostrar, Tipo {
    
    private String nombre;
    private int cedula;
    
    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    } // fin constructor
    
    @Override
    public void mostrarDatos() {
        System.out.printf("\t\t %-8s %-8d", nombre, cedula);        
    } // fin mostrarDatos() 
    
} // fin clase Persona
